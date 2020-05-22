public class BackgroundTask extends AsyncTask<String, Void, String> {

    private final Context mContext;

    public BackgroundTask(final Context context) {
         mContext = context;
    }
}