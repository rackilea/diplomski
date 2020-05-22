@Service
public class WebSocketProductService{

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // This would be the method which should inform your clients about specific product     
    // changes, instead of the String parameters a Product object should be used instead, 
    // you have to call this method yourself on product changes or schedule it or sth.
    public void sendProductChange(String product, String productId) {
        this.simpMessagingTemplate.convertAndSend("/product/changes/"+productId, product);
    }
}