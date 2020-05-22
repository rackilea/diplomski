@SpringBootApplication
public class Application {

  @Autowired
  BookingService bookingService;

  @Bean
  BookingService bookingService() {
    return new BookingService();
  }

  public static void main(String[] args) {
    bookingService.book("Alice", "Bob", "Carol");
  }
}