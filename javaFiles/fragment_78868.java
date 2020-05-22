@Rule
public ExpectedException thrown = ExpectedException.none();

@Test
public void testMethod1WhenMethod2ThrowsException() throws Exception {
    thrown.expect(Exception.class);
    thrown.expectMessage("expected exception message");

    myServive.method1();
}