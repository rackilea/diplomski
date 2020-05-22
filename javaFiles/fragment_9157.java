import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appDependencies = Seq(
    "se.radley" %% "play-plugins-salat" % "1.2-SNAPSHOT"
  )

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
    resolvers       += "OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
    routesImport    += "se.radley.plugin.salat.Binders._",
    templatesImport += "org.bson.types.ObjectId"
  )
}