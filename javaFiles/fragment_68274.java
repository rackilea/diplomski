public class MQTTService extends Service {

private MqttAndroidClient clientPhone;

@Override
  public void onCreate() {
    super.onCreate();
    registerReceiver();
    new Thread(() -> init()).start();
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    //do something
    return START_STICKY;
}

@Override
public IBinder onBind(Intent intent) {
    return null;
}

private void registerReceiver(){
    m_ScreenOffReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(final Context context, Intent intent){
            //Log.d(TAG,"onReceive of Wifi_State_Change called");
            if(intent.getAction().equals(WifiManager.WIFI_STATE_CHANGED_ACTION))
            {
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
                if(wifiState != WifiManager.WIFI_STATE_ENABLED)
                    return;

                final WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                new Handler().postDelayed(() -> {
                        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                        String ssid = wifiInfo.getSSID();
                        //Toast.makeText(context, "active wifi:"+ssid, Toast.LENGTH_SHORT).show();

                        //You can connect to the your mqtt broker again:
                        connectMQTT();
                }, 10000);
            }
        }
    };

    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
    registerReceiver(m_ScreenOffReceiver, intentFilter);
}

private void init() {

    clientPhone = new MqttAndroidClient(this, "tcp://IP:PORT", "Your-CLIENT-ID");       
    //clientPhone = new MqttAndroidClient(this, "ssl://IP:PORT", "Your-CLIENT-ID");

    clientPhone.setCallback(new MqttCallback() {
        @Override
        public void connectionLost(Throwable cause) {
            //do something - for example reconnnect again
        }

        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {
            //you can do everything with the received message from broker here
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {
            //do something
        }
    });
}

private MqttConnectOptions getOptions(){

    if(clientPhone.getServerURI().contains("ssl")) {
        //set ssl config.for example:
                //options.setSocketFactory(clientPhone.getSSLSocketFactory(YOUR_KEYSTORE_FILE, "YOUR_KEYSTORE_PASSWORD"));
                //...
    }
    options.setKeepAliveInterval(...);
    options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
    options.setAutomaticReconnect(true);
    options.setCleanSession(...);
    //options.setWill(...);
    options.setUserName(...));
    options.setPassword(...);
    return options;
}

private void connectMQTT() {
    try {
        //getOptions is a method that returns your MqttConnectOptions object
        IMqttToken token = clientPhone.connect(getOptions());
        token.setActionCallback(new IMqttActionListener() {
            @Override
            public void onSuccess(IMqttToken asyncActionToken) {
                //do something
            }
            @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
            @Override
            public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                //do something
            }
        });
    } catch (MqttException e) {
                //do something
        e.printStackTrace();
    }
}


@Override
public void onDestroy() {
    if(clientPhone!=null) {
        /*unregisterResources is needed,otherwise receive this error:
          has leaked ServiceConnection org.eclipse.paho.android.service.MqttAndroidClient*/
        try {
            clientPhone.unregisterResources();
            clientPhone.close();
            clientPhone.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    unregisterReceiver(m_ScreenOffReceiver);
    m_ScreenOffReceiver = null;
        ...
    super.onDestroy();
}

}