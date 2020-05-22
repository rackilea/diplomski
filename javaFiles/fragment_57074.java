public class YourActivity extends ActionBarActivity {

    private ListView lv;
    private SettingsAdapter adapter;
    private List<SettingsList> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.operations);
        itemList = new ArrayList<>();
        itemList.add(new SettingsList(R.drawable.wifi, Nearby Wifi));
        itemList.add(new SettingsList(R.drawable.bluetooth, Nearby Blutooth));
        itemList.add(new SettingsList(R.drawable.usb, Direct USB Connected));
        itemList.add(new SettingsList(R.drawable.cloud, Google Cloud Print));
        adapter = new SettingsAdapter(YourActivity.this, R.layout.list_row_item, itemList);
        lv.setAdapter(adapter);

    }

}