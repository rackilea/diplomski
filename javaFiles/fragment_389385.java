public class PropertyReader {

    private static PropertyReader ourInstance = new PropertyReader();
    private Context mContext;

    public static PropertyReader getInstance() {
         return ourInstance;
    }

    private PropertyReader() {
    }

    public void loadProperties(Context context) {
         mContext = context;
         try {
             properties = new Properties();
             properties.load(context.getResources().getAssets().open("badass.properties"));
         } catch (IOException e){
             Log.e("Error", "Error opening properties file", e);
         }
    }

}