public class MainActivity extends ActionBarActivity implements ShipInfoManager.MyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ShipInfoManager s = new ShipInfoManager(this);
        s.setCustomEventListener(this);
    }

    @Override
    public void callbackCall() {

    }
}