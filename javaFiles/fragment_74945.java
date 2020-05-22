@Test public void test1() {
  Parabola target = new Parabola(1, 2, 3);
  assertEquals(target.x1(), 44.23);
  assertEquals(target.x2(), 17.23);
}

@Test public void test2() {
  Parabola target = new Parabola(1, 0, 0);
  assertEquals(target.x1(), -1);
  assertEquals(target.x2(), 13.43);
}