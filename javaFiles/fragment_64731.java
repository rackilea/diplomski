@Test
public void test1() {
// test something (1)
}

@Test(dependsOnMethods = { "test1" })
public void test2() {
// test something (2)
}