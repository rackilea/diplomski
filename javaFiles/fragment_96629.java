public class Shopper extends Application {
private static Context context;

@Override
public void onCreate() {
    super.onCreate();
    context = getApplicationContext();
}

public static Context getContext() {
    return context;
}
}