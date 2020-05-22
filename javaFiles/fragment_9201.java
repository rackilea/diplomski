import org.springframework.util.AutoPopulatingList;
public class ClientBackingBean {
  private Client client = new Client();
  private List<Address> addresses = new AutoPopulatingList<Address>(Address.class);
  ...
  <getters and setters>
}