package info.vizierdb.ui

import org.scalajs.dom.document
import scalatags.JsDom.all._
import org.scalajs.dom
import rx._
import scala.concurrent.ExecutionContext.Implicits.global

import rxExtras.implicits._
import rxExtras.RxBufferView
import state.BranchSubscription
import view.WorkflowView

object WebApp {
  import Ctx.Owner.Unsafe._
  implicit val dataCtx = new Ctx.Data(new Rx.Dynamic[Int]( (owner, data) => 42, None ))

  val state = Var[Int](0)
  val api = API("http://localhost:5000/vizier-db/api/v1")
  var workflowView: WorkflowView = null

  def main(args: Array[String]): Unit = 
  {
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) => 
      println("Project")
      api.project("1")
         .onSuccess { case project =>
            println(s"Project: $project")
            project.defaultBranch
                   .onSuccess { case branch =>
                      println(s"Branch: $branch")
                      val subscription = branch.subscribe
                      workflowView = new WorkflowView(subscription)
                      document.body.appendChild(workflowView.root)
                   }
         }
    })
  }

}  
