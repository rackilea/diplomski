public class DirecoryWatcher{
    private static String FOLDER;

    public static synchronized getFolder(){
        if(FOLDER == null){
            // FOLDER = your loading code
        }
        return FOLDER;
    }
}