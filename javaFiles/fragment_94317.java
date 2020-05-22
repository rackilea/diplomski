val a = stringList(0)
val b = stringList(1)
val c = stringList(2)

val (a, b, c) = stringList match {
  case first :: second :: third :: _ => (first, second, third)
  case _ => ("default for a", "default for b", "default for c") // default case..
}