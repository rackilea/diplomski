class A {
  def meth(a: String, b: String) = a + b
}
val host = (new A)
val method = host.getClass.getDeclaredMethods.head
val params: List[Object] = List("a", "b")
val result = method.invoke(host, params: _*)
println(result) // ab