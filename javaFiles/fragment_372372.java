class Shopping { this: Item =>
  def shop(order: Order): Unit = {
    println(s"shopping with $name")
    applyOrder(order)
  }
}