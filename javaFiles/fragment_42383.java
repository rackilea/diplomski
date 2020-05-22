@Stateless
@Path("services")
public class MyServices {

  @PersistenceContext
  private EntityManager em;

// ...