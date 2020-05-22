public class ProductTest {
  @Rule
  public EmbeddedDataStore store = new EmbeddedDataStore();

  @Before
  public void register() {
    ObjectifyService.register(Product.class);
  }

  @Test
  public void accessObjectifyWithSuccess() {
    Objectify ofy = ObjectifyService.begin();
    ofy.put(new Product());
    assertEquals(1, ofy.query(Product.class).list().size());
  }
}