public class AppApplication extends Application {

    public static StringConstant STRING_CONSTANT;

    @Override
    public void onCreate() {
        super.onCreate();

        STRING_CONSTANT = new StringConstant(getBaseContext());
        STRING_CONSTANT.build();
    }
}