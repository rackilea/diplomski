public class MITJavaWordNetInterface 
{
    String wnhome;
    String path;
    URL url;

    IDictionary dict;

    public MITJavaWordNetInterface() {
        wnhome = System.getenv("WNHOME");
        path = wnhome + File.separator + "dict";
        url = new URL ("file", null, path);
        dict = new Dictionary(url) ;
        dict.open();
    }

    public void getHypernyms(String inut_word) throws IOException {
        ...
    }

    public void getStem(String word) {
        ...
    }
}