public class OrderNotification implements Notification {

    private String orderNumber;

    public OrderNotification(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getMessage() {
        return "Order number: " + orderNumber;
    }

    //Getter & Setters
    ...
} 

@Service
public class NotificationService {

    @Autowired
    public TranslationService translationService;

    public void send(Notification notification) {
        //I do not know what trans accepts, so I assume it can accept Notification
        translationService.trans(notification.getMessage());
    }
}