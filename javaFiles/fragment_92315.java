public class CommandMessage extends Message {

    protected CommandMessage() {
        super();
    }

    public static CommandMessage newMessage() {
        return new CommandMessage();
    }

    public CommandMessage withCommand(String command) {
        return this;
    }
}