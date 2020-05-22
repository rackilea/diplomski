public class CustomerLoggingApp {
    public static void main(String[] args) {
        Logger log = LogManager.getLogger();

        Customer customer = new Customer();
        customer.name = "Jesse Zhuang";
        customer.password = "secret123";

        log.info("This is sensitive and should not be logged: {}", customer);
        log.info("But this message should be logged.");
    }
}