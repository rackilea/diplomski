import javax.enterprise.inject.spi.CDI;

public class UserDeserializer extends JsonDeserializer<User> {

  private final UserFacadeREST userFacade =
      CDI.current().select(UserFacadeREST.class).get();

  // Rest as before
}