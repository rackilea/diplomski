import NativePackagerKeys._
import sbt._
import Keys._

name := "openie"
organization := "edu.washington.cs.knowitall.openie"
crossScalaVersions := Seq("2.10.2")
scalaVersion <<= crossScalaVersions { (vs: Seq[String]) => vs.head }

resolvers += "Sonatype SNAPSHOTS" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  // extractor components
  "edu.washington.cs.knowitall.srlie" %% "srlie" % "1.0.3",
  "edu.washington.cs.knowitall.chunkedextractor" %% "chunkedextractor" % "2.2.1",
  // for splitting sentences
  "edu.washington.cs.knowitall.nlptools" %% "nlptools-sentence-opennlp" % "2.4.5",
  // for remote components
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
  // resource management
  "com.jsuereth" %% "scala-arm" % "1.3",
  // logging
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "ch.qos.logback" % "logback-core" % "1.0.13",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "org.scalatest" % "scalatest_2.10" % "2.0.RC1" % "test",
  "commons-lang" % "commons-lang" % "2.6")

mainClass in assembly := Some("edu.knowitall.openie.OpenIECli")

scalacOptions ++= Seq("-optimize", "-unchecked", "-deprecation")

assemblyOption in assembly := (assemblyOption in assembly).value.copy(cacheUnzip = true)
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = true, includeDependency = true)
assemblyOption in assembly := (assemblyOption in assembly).value.copy(cacheOutput = false)

// custom options for high memory usage

javaOptions += "-J-XX:MaxMetaspaceSize=2G"
javaOptions += "-J-XX:+CMSClassUnloadingEnabled"
javaOptions += "-J-Xmx3G"
javaOptions += "-XX:+UseConcMarkSweepGC"

traceLevel in run := 0
fork in run := true

//test in assembly := {}
//fork in Test := true

connectInput in run := true // forward stdin/out to fork

licenses := Seq("Open IE Software License Agreement" -> url("https://raw.github.com/knowitall/openie/master/LICENSE"))
homepage := Some(url("https://github.com/knowitall/openie"))

publishMavenStyle := true
publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (  <scm>
    <url>https://github.com/knowitall/openie</url>
    <connection>scm:git://github.com/knowitall/openie.git</connection>
<developerConnection>scm:git:git@github.com:knowitall/openie.git</developerConnection>
    <tag>HEAD</tag>
  </scm>
  <developers>
   <developer>
      <name>Michael Schmitz</name>
    </developer>
    <developer>
      <name>Bhadra Mani</name>
    </developer>
  </developers>)

packagerSettings
packageArchetype.java_application

mappings in Universal ++= Seq(
  file("README.md") -> "README.md",
  file("LICENSE") -> "LICENSE"
)