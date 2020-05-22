object Hello extends App {
  println("HELLO")

  val randomData = new RandomDataGenerator()

  println(randomData.nextLong(0, 100))
}