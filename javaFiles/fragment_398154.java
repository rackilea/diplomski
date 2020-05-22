@Service
public class FakeService {
    @Autowired private EcomService ecomService;
    @Autowired private WebService webService;

    @Transactional(noRollbackFor={XFireRuntimeException.class})
    public void doSomeTransactionalStuff() {
        Order order = ecomService.findOrderById(459);

        try {
            webService.letsThrowAnException();
        } catch (XFireRuntimeException e) {
            System.err.println("Caugh XFireRuntimeException:" + e.getMessage());
        }

        order.setBookingType(BookingType.CAR_BOOKING);
        ecomService.persist(order);
    }
}