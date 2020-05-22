@Rule
public ExpectedException thrown = ExpectedException.none();

@Test
public void myTest() {
    List<Object[]> paramsList = Arrays.asList(
        new Object[] {"", IllegalArgumentException.class},
        new Object[] {null, NullPointerException.class});
    paramsList.forEach(a -> assertExceptionForParam((String)a[0], (Class)a[1]));
}

private void assertExceptionForParam(String param, Class expectedExceptionClass) {
    thrown.expect(expectedExceptionClass);
    testedObject.supposedToFail(param);
}