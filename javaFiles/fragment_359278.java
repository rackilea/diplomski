public class ClassToBeTestedTest
{
    @Tested ClassToBeTested classUnderTest;
    @Injectable ISomeInterface mockSomeInterface;

    @Test
    public void exampleTest() {
        String mockResp = "mockResp";
        new Expectations() {{
            // There is *one* expectation, not two:
            mockSomeInterface.doSomething(anyString, anyString);

            times = 2; // specify the expected number of invocations

            // specify one or more expected results:
            result = new MyException();
            result = mockResp;
        }};

        String resp = classUnderTest.callInterfaceMethod();

        assertEquals(mockResp, resp);
    }
}