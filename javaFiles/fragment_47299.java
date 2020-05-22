class Leakable(i: Int)(implicit r: Region) {
  // Class body is constructor body, so you can register finalizers
  r.register(() => println(s"Deallocated foo $i"))

  def foo() = println(s"Foo: $i")
}