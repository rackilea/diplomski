public class MainActivity extends Activity {
    public static final String MIXPANEL_TOKEN = "xxxxx";
    MixpanelAPI mixpanel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mixpanel =
                MixpanelAPI.getInstance(getApplicationContext(), MIXPANEL_TOKEN);

        setContentView(R.layout.activity_main);

        JSONObject props = new JSONObject();

        mixpanel.track("Plan Selected", props);
    }
  (...)