public class MITJavaWordNetInterface 
{
    static String wnhome;
    static String path;
    static URL url;

    static IDictionary dict;

    static {
        wnhome = System.getenv("WNHOME");
        path = wnhome + File.separator + "dict";
        url = new URL ("file", null, path);
        dict = new Dictionary(url) ;
        dict.open();
    }

    public static void getHypernyms(String inut_word) throws IOException {
        ...
    }

    public static void getStem(String word) {
        ...
    }
}