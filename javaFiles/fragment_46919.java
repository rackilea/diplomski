WifiManager wifiMgr =null;
WifiInfo wifiInfo = null;
String WifiName = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
     wifiMgr= (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
     wifiInfo = wifiMgr.getConnectionInfo();
    WifiName = wifiInfo.getSSID();
    TextView outputWifiName = (TextView) findViewById(R.id.sysInf);

    outputWifiName.setText(WifiName);

}