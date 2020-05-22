public class TestSomeClass {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testSomeMethodWithRule() throws SomeException {
        exception.expect(SomeException.class);

        new SomeClass().someMethod("something");
    }

    @Test(expected=SomeException.class)
    public void testSomeMethodWithExpected() throws SomeException { 
        new SomeClass().someMethod("something");
    }
}