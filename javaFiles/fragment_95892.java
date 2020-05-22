public class MyTest {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().dynamicPort().dynamicHttpsPort());

    @Test
    public void exampleTest() {
        stubFor(get(urlEqualTo("/my/resource"))
                .willReturn(aResponse()
                    .withStatus(200)
                    .withBody("<response>Some content</response>")));

        ...        
        verify(postRequestedFor(urlMatching("/my/resource/[a-z0-9]+"))
                .withRequestBody(matching(".*<message>1234</message>.*")));
    }
}