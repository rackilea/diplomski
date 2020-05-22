@Configuration
public class JerseyConfig extends ResourceConfig {
  public JerseyConfig() {
    register(GlobalExceptionHandlerController.class);
    register(CustomerEndpoint.class); // your existing controller
  }
}