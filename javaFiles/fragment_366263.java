WireMockServer server = new WireMockServer(options().bindAddress("127.0.0.1").port(port));
server.stubFor(get(urlEqualTo(urlWithId))
                .willReturn(aResponse()
                        .withStatus(HTTPOK)
                        .withHeader("Content-Type", "application/json")
                        .withBody(response)));
server.start()
myService.callService();