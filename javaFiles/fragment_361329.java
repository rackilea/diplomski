trait Machine {
  // Notes:
  // - no need to use 'return' keyword
  // - It's good practice in Scala not to return null: use Option for optional values
  def checkAvl(name :String): Option[Product] =
    productMap.get(name)
}

class VendingMachineImpl() extends Machine{
  override def process(name : String): Unit ={
    val product = checkAvl(name)
    // Think of Option as a collection containing 0 or 1 element: you can use
    // foreach, map, etc.
    // Also, string interpolation (with the s"" syntax) is cool. :-)
    product.foreach(print(p => s"Got you : $p"))
  }
}