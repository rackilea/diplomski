@RunWith(PowerMockRunner.class)
public class ClassUnderTestTest {

    @PrepareForTest({InetAddress.class, ClassUnderTest.class})
    @Test
    public void testFunc() throws Exception {
        final ClassUnderTest classUnderTest = new ClassUnderTest();

        PowerMockito.mockStatic(InetAddress.class);
        final InetAddress inetAddress = PowerMockito.mock(InetAddress.class);
        PowerMockito.doReturn("testHost", "anotherHost")
                .when(inetAddress, PowerMockito.method(InetAddress.class, "getHostName"))
                .withNoArguments();
        PowerMockito.doReturn(inetAddress).when(InetAddress.class);
        InetAddress.getLocalHost();

        Assert.assertEquals("testHost", classUnderTest.printHostname());
        Assert.assertEquals("anotherHost", classUnderTest.printHostname());
    }

}