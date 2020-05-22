public class ExampleTest {
    @Tested A a;

    @Test
    public void exampleTest(@Mocked B anyB) {
        // Record calls to methods on B, if/as needed by code under test:
        new Expectations() {{ anyB.doSomething(); result = "mock data"; }};

        // Exercise the code under test:
        a.methodOne(123);

        // Verify a call to some other method on B, if applicable:
        new Verifications() {{ anyB.someOtherMethod(anyString, anyInt); }};
    }
}