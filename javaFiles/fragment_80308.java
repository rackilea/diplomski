public class BluetoothConnectionService {
    // ...
    private static class InstanceHolder {
        private static final BluetoothConnectionService INSTANCE = new BluetoothConnectionService();
    }

    public static BluetoothConnectionService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private BluetoothConnectionService() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        start();
    }

    public void setContext(Context context) {
        mContext = context;
    }

    // ...
}