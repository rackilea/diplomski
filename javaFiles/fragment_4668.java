object Hello extends App {
  import scala.collection.immutable

  type F1 = (Any) => Any

  val hashMap: immutable.Map[Int, F1] =
    immutable.HashMap[Int, F1](
      1    -> { (a: Int)               => a * 2               }.asInstanceOf[F1], // Function literal that doubles it's input
      2    -> { (tuple: (String, Int)) => tuple._1 * tuple._2 }.asInstanceOf[F1], // Function literal that repeats the string
      1000 -> { (_: Unit)              => s"The date and time is ${ new java.util.Date() }" }.asInstanceOf[F1]
    )

  def lookup(i: Int, args: Any): Any = hashMap(i)(args)

  def report(i: Int, args: Any): Unit = println(s"$i: ${ lookup(i, args) }")

  report(1, 21)
  report(2, ("word ", 5))
  report(1000, ())
}