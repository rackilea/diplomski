import sbt._
import complete.DefaultParsers._

lazy val loadArgTask = inputKey[Unit]("loads and transforms argument")

lazy val runStuff = taskKey[Unit]("Runs some stuff")

lazy val loadArgIntoPropertyTask: Def.Initialize[InputTask[Unit]] = Def.inputTask {
    val myArg = (token(Space) ~> token(StringBasic, "<myArg>")).parsed
    System.setProperty("myArg", myArg + "foo")
}

loadArgTask <<= loadArgIntoPropertyTask

runStuff := {
    println(System.getProperty("myArg"))
}