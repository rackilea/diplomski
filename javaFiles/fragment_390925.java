public class YourClass extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            if (data.equals("correcting_post")) {
                try {
                    ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                    List<KeyboardRow> keyboard = new ArrayList<>();
                    KeyboardRow row = new KeyboardRow();
                    row.add("Test button");
                    keyboard.add(row);
                    keyboardMarkup.setKeyboard(keyboard);

                    // Create a message object
                    SendMessage message = new SendMessage()
                            .setChatId(update.getCallbackQuery().getMessage().getChatId())
                            .enableMarkdown(true)
                            .setText("Message text");
                    message.setReplyMarkup(keyboardMarkup);
                    execute(message);
                } catch (TelegramApiException e) {
                    //exception handling
                }
            }
            //Check another options for data
        }
    }

    ...
}