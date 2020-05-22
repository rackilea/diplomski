@Component
public class SimpleLoggingComponent {

    /*previously code omitted for brevity*/

    private MessageProvider messages;

    @Reference
    public void bindMessageProvider(MessageProvider messageProvider) {
        messages = messageProvider;
    }

    /*unbind methods omitted*/

    @Activate
    public void activate() {
        simpleLogService.log(messages.get("startMessage")); // <- use now the key: startMessage
    }

    @Deactivate
    public void deactivate() {
        simpleLogService.log(messages.get("endMessage")); // <- use now the key: endMessage
    }
}