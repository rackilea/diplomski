public class NewJerseyClient {
  private WebTarget webTarget;
  private Client client;
  private static final String BASE_URI = "http://localhost:8086/TranslatorREST/Translator";

  public NewJerseyClient() {
    client = javax.ws.rs.client.ClientBuilder.newClient();
    webTarget = client.target(BASE_URI);
  }

  public String translate() throws ClientErrorException {
    return webTarget.path("translate").queryParam("dir", "myDir")
        .queryParam("string", "myString")
        .queryParam("user", "myUser")
        .queryParam("key", "myKey").request().post(null, String.class);
  }
}