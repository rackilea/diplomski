object Hello2 extends App {
  type F1 = (Any) => Any

  val array: Array[F1] =
    Array[F1](
      { (a: Int)               => a * 2               }.asInstanceOf[F1], // Function literal that doubles it's input
      { (tuple: (String, Int)) => tuple._1 * tuple._2 }.asInstanceOf[F1], // Function literal that repeats the string
      { (_: Unit)              => s"The date and time is ${ new java.util.Date() }" }.asInstanceOf[F1]
    )

  def lookup(i: Int, args: Any): Any = array(i)(args)

  def report(i: Int, args: Any): Unit = println(s"$i: ${ lookup(i, args) }")

  report(0, 21)
  report(1, ("word ", 5))
  report(2, ())
}