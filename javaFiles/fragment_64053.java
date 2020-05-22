public class MainActivity extends Activity {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("Native");
    }
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity=MainActivity.this;
        setStoreBoolValues(activity, true);

        if (getStoreValues(activity))
            Log.e("Store Value", " ** true **");
        else
            Log.e("Store Value", " ** false **");
    }

    public native boolean getStoreValues(Activity activity);
    public native void setStoreBoolValues(Activity activity, boolean flag);
}