class Translate extends YandexTranslatorAPI {
    public static String message;
    //prevent instantiation
    private Translate() {
    }
    public static void main(String[] args) {
        try {
            setKey(ApiKeys.YANDEX_API_KEY);
            String translation = Translate.execute("The quick brown fox jumps over the lazy dog.", Language.ENGLISH, Language.SPANISH);
            message = translation;
            System.out.println("Translation: " + translation);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}