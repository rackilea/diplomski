@PostConstruct
public void registerBot(){
     TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
     try {
       telegramBotsApi.registerBot(this);
     } catch (TelegramApiException e) {
       logger.error(e);
}