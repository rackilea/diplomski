@RunWith(PowerMockRunner.class)
@PrepareForTest({DigestUtils.class})
public class TestTest {

    private RequestUtil sut = new RequestUtil();

    @Test
    public void testGenerateCode() {
        PowerMockito.mockStatic(DigestUtils.class);

        byte[] input = "anInput".getBytes();
        final String hex = "0beec7";
        Mockito.when(DigestUtils.sha1Hex(input)).thenReturn(hex);

        String actual = sut.generateCode(input);
        Assert.assertEquals(hex.toUpperCase(), actual);
    }
}