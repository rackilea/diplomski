public class Respository {
    private NetworkAPI networkAPI;

    public Single<TranslatedResponse> fetchTranslation(final String message) {
        return new Translation(
            message,
            networkAPI.fetchTranslation(new TranslateRequest(message)
        );
    }
}