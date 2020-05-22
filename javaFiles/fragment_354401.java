public class myMock {

 private static WireMockServer wireMockServer;


 public static void main(String args[]){

    wireMockServer = new WireMockServer(WireMockConfiguration.
            options().notifier(new 
ConsoleNotifier(true)).extensions(IdTransformer.class));

stubFor(post(urlEqualTo("/api/commands/vehicles/FAKEBMWVEHICLE001"))
            .willReturn(aResponse()
                    .withTransformers("idTransformer")
                  ));
}