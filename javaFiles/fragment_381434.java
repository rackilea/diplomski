public class MessageWriter {

    @Autowired
    private MessageGetter messageGetter;

    @Autowired
    private MessageDisplayer messageDisplayer;

    public void writeMessage() {
        String message = messageGetter.getMessage();
        messageDisplayer.displayMessage(message);
    }

}