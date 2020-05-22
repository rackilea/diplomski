public class AddressBookApp {
  public static void main(String[] args) {
    Configuration conf = new Configuration(args[0]);

    // Creates our Repository, this might do some internal JDBC initialization
    AddressBookRepository repo = new AddressBookRepository(conf);

    // Pass the Repository to our Service object so that it can persist data
    AddressBookService service = new AddressBookService(repo);

    // Pass the Service to the web controller so it can invoke business logic
    AddressBookController controller = new AddressBookController(conf, service);

    // Now launch it! 
    new WebApp(new Controller[] { controller }).start();
  }
}