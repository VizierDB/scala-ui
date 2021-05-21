package info.vizierdb.ui

import scala.scalajs.js
import scala.scalajs.js.JSON
import org.scalajs.dom.ext.Ajax

import info.vizierdb.VizierURLs
import info.vizierdb.types._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import state.{
  ProjectDescription,
  Project,
  BranchDescription,
  Branch,
}

case class API(baseUrl: String)
{
  val urls = new VizierURLs(baseUrl)

  def project(
    projectId: Identifier
  ): Future[Project] =
  {
    Ajax.get(
      urls.getProject(projectId).toString
    ).map { xhr =>
      JSON.parse(
        xhr.responseText
      )
    }.map {
      _.asInstanceOf[ProjectDescription]
    }.map { 
      new Project(_, this)
    }
  }

  def branch(
    projectId: Identifier, 
    branchId: Identifier
  ): Future[Branch] =
  {
    Ajax.get(
      urls.getBranch(projectId, branchId).toString
    ).map { xhr =>
      JSON.parse(
        xhr.responseText
      )
    }.map {
      _.asInstanceOf[BranchDescription]
    }.map { 
      new Branch(_, projectId, this)
    }
  }


}