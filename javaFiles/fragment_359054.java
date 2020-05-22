@Service
public class Master{

    @Autowired
    NotificationService notificationService

    public void testMethod(){
        Notification notification = notificationService.createOrder("order1");
        notificationService.send(notification);
    }

}

@Service
public class NotificationService {

    @Autowired
    public TranslationService translationService;

    public Notification createOrder(String orderNumber){
        return new OrderNotification(orderNumber, translationService);
    }

    public void send(Notification notification) {
        // call other services and send the notification
        notification.getMessage();
    }
}


public class OrderNotification implements Notification {

    private TranslationService translationService;

    private String orderNumber;

    //I have changed this constructor to accept TranslationService.
    public OrderNotification(String orderNumber, TranslationService translationService) {
        this.orderNumber = orderNumber;
        this.translationService = translationService;
    }

    public String getMessage() {
        return translationService.trans('notification.order', new Object[]{orderNumber});
    }
}