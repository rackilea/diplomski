@Test
public void testClassExists {
    try {
        Class.forName("org.mypackage.Car");
    } catch (ClassNotFoundException e) {
        Assert.fail("should have a class called Car");
    }
}