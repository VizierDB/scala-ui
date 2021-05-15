import mill._, scalalib._
import $ivy.`com.lihaoyi::mill-contrib-bloop:$MILL_VERSION`
import mill.scalajslib.ScalaJSModule

object ui extends ScalaJSModule {
  def scalaVersion = "2.12.12"
  def scalaJSVersion = "1.5.1"

  def ivyDeps = Agg(
    ivy"org.scala-js::scalajs-dom::1.0.0",
    ivy"com.lihaoyi::scalarx::0.4.3",
    ivy"com.lihaoyi::scalatags::0.9.4",
  )

}
