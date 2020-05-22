public class StringConstant {

    private Context context;

    public static String appName;
    // declare other String variables


    public StringConstant(Context context) {
        this.context = context;
    }

    public void build(){
        setAppName(context.getString(R.string.app_name));
        // set other String variables
    }

    public static String getAppName() {
        return appName;
    }

    public static void setAppName(String appName) {
        StringConstant.appName = appName;
    }
}