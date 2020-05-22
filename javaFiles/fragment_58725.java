@Component
public class MyClient {

  @Value("${my.rest.uri}")
  private String MyUri;

  /**
   * Log user actions.
   */
  public void saveAction(..parameters..) {
    RestTemplate restTemplate = new RestTemplate();
    String queryParameters = String.format("...parameters...");
    restTemplate.postForObject(MyUri + "?" + queryParameters,null, ResponseEntity.class);
  }
}