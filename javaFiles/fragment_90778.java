public final class CommandHandler {

    public static void handleCmd(String userMessage) {
        if(userMessage == null){
            return;
        }
        String command = userMessage.substring(1);

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