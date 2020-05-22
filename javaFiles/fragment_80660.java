public class Bot extends TelegramLongPollingBot {
    private static final String TOKEN = System.getenv("TOKEN");
    private static final String BOT_USERNAME = System.getenv("BOT_USERNAME");
    private static final String PORT = System.getenv("PORT");

    public void onUpdateReceived(Update update) {

    }

    public String getBotUsername() {
        return BOT_USERNAME;
    }

    public String getBotToken() {
        return TOKEN;
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        try {
            api.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

        try (ServerSocket serverSocket = new ServerSocket(Integer.valueOf(PORT))) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}