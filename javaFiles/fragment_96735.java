@BeforeMethod(groups = "a")
public void setupForGroupA() {
...
}

@Test(groups = {"supplemental", "a"})
public void test() {
...
}

@Test(groups = {"supplemental"})
public void test2() {
...
}