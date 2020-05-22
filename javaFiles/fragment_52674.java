@Controller
@AllArgsConstructor
public class ChannelController {

    private final SimpMessagingTemplate messagingTemplate; 

    @MessageMapping("/books/{id}")
    public void receive(@DestinationVariable("id") Long bookId, SimpMessageHeaderAccessor accessor ) {
        accessor.setHeader("message-type", "BOOK");

        messagingTemplate.convertAndSend(
            "/topic/books/" + bookId, findBook(bookId), accessor.toMap()
        );
    }

    private Book findBook(Long bookId) {
        return //...
    }
}