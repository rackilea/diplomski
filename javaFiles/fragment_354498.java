@Controller
public class MessageController {

  @Autowired
  private SimpMessagingTemplate template;

  @RequestMapping(path="/messages", method=POST)
  public void send(String message) {
    CommService.send(message);
  }
}