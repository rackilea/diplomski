Region.run { implicit r =>
  val a = new Leakable(1)
  val b = new Leakable(2)
  b.foo()
  a.foo()
}