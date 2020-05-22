// ...

test("extractSessions") {
  assert(Object1("blah", 0L) === Object1("blah", 0L))
  assert(Object2("blah", 0L, 0.0F) === Object2("blah", 0L, 0.0F))

  Object1("blah", 0L) shouldEqual (Object1("blah", 0L))
  Object2("blah", 0L, 0.0F) should be (Object2("blah", 0L, 0.0F))

  // Also works
  new Object1("blah", 0L) shouldEqual (new Object1("blah", 0L))
}

case class Object1(pippo: String, pappo: Long)

case class Object2(pippo: String, pappo: Long, pluto: Float)

// ...