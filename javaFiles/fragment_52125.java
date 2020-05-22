public class Bot extends TelegramLongPollingBot {

    private static int i = 0;

    public void onUpdateReceived() {
        /*...*/
        else if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equals("1. M")) {
            i++;
        } else if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equals("1. end")) {
            System.out.println(i);
        }
        /*...*/
    }

    public String getBotToken() {
        return "...";
    }

    public String getBotUsername() {
        return "...";
    }
}