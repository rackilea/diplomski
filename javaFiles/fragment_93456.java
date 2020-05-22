private final MainActivity mainActivity;
public ConnectThread(MainActivity context, BluetoothDevice device,
BluetoothAdapter adapter, UUID BT_UUID) {
 ...
 mainActivity = context;
 }