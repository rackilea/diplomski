@Controller
@EnableBinding(Sink.class)
@RabbitListener(queues = {"input", "anotherInput"})
public class InputMessageController {

    @RabbitHandler
    public void handle(String message) {
        System.out.println("Received " + message + "from " +
                   ((/*some condition*/) ? "1st" : "2nd") + " input");
    }