@Controller
public class WebSocketContoller{
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/product/register")
    public void register(@Payload Long productId, @Header("simpSessionId") String sessionId) {
        // register current websocket session with product id and 
        // then with convertAndSendToUser send changes to current user.

        // Example of how to send a message to the user using the sessionId
        String response = "This could also be one of your product objects of type Product";
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);

        messagingTemplate.convertAndSendToUser(sessionId,"/queue/product/changes", response, headerAccessor.getMessageHeaders());
    }
}