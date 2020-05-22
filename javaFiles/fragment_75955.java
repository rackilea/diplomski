public class App_Web extends Application{

    public static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    public void onCreate() {
        super.onCreate();
        //initialize myObject here, if needed
    }

    public static void deconnexion() {
        client = new AsyncHttpClient();
    }