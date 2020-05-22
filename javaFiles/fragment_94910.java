import scala.tools.nsc.interpreter._

val lines: List[String] = List("println(\"Hello\")", "println(\"Word\")")
val ret: String = ILoop.run(lines)
// Verify if all runs OK

// Read stdin
val condition = ...
while (condition) {
  // convert to List[String] 
  val ret: String = ILoop.run(lines)
  // format and print the output
  println(ret)
  // Read stdin again
}