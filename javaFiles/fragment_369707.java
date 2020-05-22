@Rule
public WireMockRule wireMockRule = new WireMockRule(8080);

@Test
public void testRetry()
  throws Exception {
    WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/retry"))
                    .inScenario("retry")
                    .whenScenarioStateIs(Scenario.STARTED)
                    .willSetStateTo("first try").willReturn(aResponse().withBody("error").withStatus(500)));
    WireMock.stubFor(
            WireMock.get(WireMock.urlEqualTo("/retry"))
                    .inScenario("retry")
                    .whenScenarioStateIs(Scenario.STARTED)
                    .willSetStateTo("first try").willReturn(aResponse().withBody("OK").withStatus(200)));
    Integer responseCode = new TestClass().getHttpClient().execute(new HttpHost("localhost", 8080), new HttpGet("http://localhost:8080/retry")).getStatusLine().getStatusCode();
    assertThat(responseCode, is(200))
}