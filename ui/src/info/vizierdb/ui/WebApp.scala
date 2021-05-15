package info.vizierdb.ui

import org.scalajs.dom.document
import scalatags.JsDom.all._
import org.scalajs.dom
import rx._

import implicits._

object WebApp {
  import Ctx.Owner.Unsafe._
  implicit val dataCtx = new Ctx.Data(new Rx.Dynamic[Int]( (owner, data) => 42, None ))

  val state = Var[Int](0)


  def setupUI(): Unit = {
    println("word")
    val button = document.createElement("button")
    button.textContent = "Click me!"
    button.addEventListener("click", { (e: dom.MouseEvent) => 
      println("Hello!")
      state() = state.now + 1
    })
    document.body.appendChild(button)
    document.body.appendChild(
      ul(
        li(Rx { println("Refresh"); state }) 
      )
    )
    state.trigger { 
      println("State: " + state)
    }

  }


  def main(args: Array[String]): Unit = 
  {
    println("Hi!")
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) => 
      setupUI()
    })
  }
}  
