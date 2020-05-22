case class Order(id: Int)

trait Item {
  // renamed to applyOrder to disambiguate it from apply(), which has special use in Scala
  def applyOrder(order: Order): Unit 
  def name: String
}

trait Sale extends Item {
  override def applyOrder(order: Order): Unit = println(s"sale on order[${order.id}]")
  override def name: String = "sale"
}

trait Discount extends Item {
  override def applyOrder(order: Order): Unit = println(s"discount on order[${order.id}]")
  override def name: String = "discount"
}