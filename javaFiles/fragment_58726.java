@Component
public class MyClient {


  private static String MyUri;

  /**
   * Log user actions.
   */
  public static void saveAction(..parameters..) {
    RestTemplate restTemplate = new RestTemplate();
    String queryParameters = String.format("...parameters...");
    restTemplate.postForObject(MyUri + "?" + queryParameters,null, ResponseEntity.class);
  }


  public void setMyUri( @Value("${my.rest.uri}") String uri) {
       MyUri = uri;
  }


}