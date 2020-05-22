@RunWith(PowerMockRunner.class)
@PrepareForTest({MyStaticClass.class})
public class PowerMockItoTest {
    @Test
    public void mockStaticClassTest() {
        PowerMockito.mockStatic(MyStaticClass.class);
        final String mockedResult = "Hi World";
        Mockito.when(MyStaticClass.helloWorld()).thenReturn(mockedResult);
        Assert.assertEquals(AStaticClass.helloWorld(), mockedResult);
    }
}