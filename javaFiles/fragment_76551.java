@EnableScheduling
@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedRate = 5000)
    public void greeting() {
        Thread.sleep(1000); // simulated delay
        System.out.println("scheduled");
        this.template.convertAndSend("/topic/greetings", "Hello");
    }

}