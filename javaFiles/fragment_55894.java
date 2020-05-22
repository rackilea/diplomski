public class LanguageFactory {
    private static final String PREFIX = "/languages/";
    public static final int ENGLISH = 1;
    public static final int GERMAN = 2;
    public static final int DEFAULT = ENGLISH;
    //List of available InProperties:

    public static final String JOIN_GAME = "joinGame";
    public static final String CREATE_GAME = "createGame";

    private static Properties language;

    public static String getString(String text){
        if(language == null){
            setLanguage(DEFAULT);
        }
        return language.getProperty(text);
    }

    public static void setLanguage(int language){
        switch (language) {
        case ENGLISH:
            setLanguage("en.lang");
            break;
        case GERMAN:
            setLanguage("de.lang");
            break;
        }
    }

    private static void setLanguage(String path){
        language = new Properties();
        try {
            InputStream fi = LanguageFactory.class.getResourceAsStream((PREFIX+path));
            language.load(fi);
            fi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}