@Test
public void myTest() {
    List<Object[]> paramsList = Arrays.asList(
        new Object[] {null, NullPointerException.class},
        new Object[] {"", IllegalArgumentException.class},
        new Object[] {"zip", NullPointerException.class});
    paramsList.forEach(a -> assertExceptionForParam((String)a[0], (Class)a[1]));
}

private void assertExceptionForParam(String param, Class expectedExceptionClass) {
    boolean pass = false;
    try {
        testedObject.supposedToFail(param);
    } catch(Exception e) {
        pass = e.getClass() == expectedExceptionClass;
    }
    Assert.assertTrue("test failed for param:" + param + " and Exception "+expectedExceptionClass, pass);
}