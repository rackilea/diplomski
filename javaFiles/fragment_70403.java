@Component("multiplexer")
public class MessageMultiplexer implements MessageHandler {
    @Autowired
    MessageHandler actualConsumer;

    ExecutorService executor = Executors.newFixedThreadPool(4);
    public void accept(MessageBO msg) {
        executor.submit(msg -> actualConsumer.handle(msg));
    }
}