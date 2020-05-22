public class CommandHandler extends MessageHandler {
    private String command;

    /**
    *   You can add more parameters to this constructor or also a MessageHandler object.
    **/
    public CommandHandler(String userMessage){
        if(userMessage != null){
            this.comand = userMessage.substring(1);
        }
    }

    public void handleCmd() {
        switch (command) {
            case "join":
                new VoiceHandler().join();
                break;
            case ... :
                ...
                break;
            case ... :
                ...
                break;
        }
    }
}