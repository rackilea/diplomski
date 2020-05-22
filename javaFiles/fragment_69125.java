@Controller
@RequestMapping("/message")
public class MessageController {

  @Autowired
  private MessageRepository messageRepository;

  @ModelAttribute
  public Message modelAttribute(@RequestParam("id") int id) {
      return messageRepository.getMessageById(id);
  }

  @GetMapping
  public String handleMessage(Model model,@ModelAttribute("message") Message message) {
    System.out.println(message);

    return "message";
  }
}