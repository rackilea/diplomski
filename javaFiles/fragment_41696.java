@RunWith(PowerMockRunner.class)
@PrepareForTest({ObjectMapper.class})
public class WtfTest {

    @Test
    public void test_intakeDataFromUrl() throws Exception {
        String in = "in";
        String out = "out";

        ObjectMapper mapper = mock(ObjectMapper.class);

        PowerMockito.whenNew(ObjectMapper.class)
                .withNoArguments()
                .thenReturn(mapper);

        Mockito.when(mapper.readValue(in, String.class)).thenReturn(out);

        assertEquals(out, intakeDataFromUrl(in));
    }

    private String intakeDataFromUrl(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, String.class);
    }
}