@ApplicationScoped
@Startup
public class AnyNameForYourApplicationClass {

  @PostConstruct
  public void connectDB() {
    // creates the db connection at startup
  }

  @PreDestoy
  public void disconnectDB() {
    // disconnects from the db
  }
}