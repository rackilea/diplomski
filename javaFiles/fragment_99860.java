public class WhileImOut extends Application {

    public static TaskManager taskManager;
    private static Context appContext;

    public void onCreate() {
        super();
        appContext = this;
        initialize();
    }

    public static void initialize() {
        if (taskManager == null && Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            try{
            File f = appContext.getExternalFilesDir(null); // Exception being thrown here
            taskManager = new TaskManager(f.getAbsolutePath());
            }catch(NullPointerException e){
                Log.d("Bad","NPE");
            }catch(Exception e){

            }
        }
    }
}