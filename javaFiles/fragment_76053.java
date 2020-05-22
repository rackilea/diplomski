public class ActivityDelegate extends ReactActivityDelegate {
    private Bundle mInitialProps = null;
    private final @Nullable Activity mActivity; 

    public ActivityDelegate(Activity activity, String mainComponentName) {
        super(activity, mainComponentName);
        this.mActivity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mInitialProps = new Bundle();
        final Bundle bundle = mActivity.getIntent().getExtras();  
        if (bundle != null && bundle.containsKey("sendAlarm")) {
            if (bundle.getString("sendAlarm").equals("sendAlarmOn")) {
                mInitialProps.putBoolean("alarmOn", true);
            }
        }       
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Bundle getLaunchOptions() {
        return mInitialProps;
    }
};

@Override
protected ReactActivityDelegate createReactActivityDelegate() {
    return new ActivityDelegate(this, getMainComponentName());
}