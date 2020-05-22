@RunWith(PowerMockRunner.class)
@PrepareForTest({MyStaticClass.class})
public class PowerMockTest {
    @Test
    public void testRegisterService() throws Exception {   
        PowerMock.mockStatic(MyStaticClass.class);
        final String mockedResult = "Hi World";
        expect(MyStaticClass.helloWorld()).andReturn(mockedResult);
        replay(MyStaticClass.class);
        Assert.assertEquals(AStaticClass.helloWorld(), mockedResult);
        verify(MyStaticClass.class);
    }
}