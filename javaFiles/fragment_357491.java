trait CopyableTo[-T] {
  def copyTo(t: T)
}

class A(private var a: Int) extends CopyableTo[A] {
  override def copyTo(t: A) {
    println("A:copy")
    t.a = this.a
  }
}

class B(private var a: Int, private var b: Int) extends A(a) with CopyableTo[B] {
  def copyTo(t: B) {
    println("B:copy")
    super.copyTo(t)
    t.b = this.b
  }
}

@Test
def zzz {
  val b1 = new B(1, 2)
  val a1 = new A(3)
  val b2 = new B(4, 5)
  b1.copyTo(a1)
  a1.copyTo(b1)
  b1.copyTo(b2)
}