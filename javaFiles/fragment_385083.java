public class Registry {
    static Map<String,FileReader> reg = new HashMap<String,FileReader>();

    public static void register(String ext, FileReader fr ) {
        reg.put( ext, fr );
    }
}