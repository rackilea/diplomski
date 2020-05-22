import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothAdapter;

...

final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
private BluetoothAdapter mBluetoothAdapter;

...

if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH)) {
    // BLUETOOTH is NOT SUPPORTED
    //use PackageManager.FEATURE_BLUETOOTH_LE if you need bluetooth low energy
    return false;
} else {
    mBluetoothAdapter = bluetoothManager.getAdapter();
    if (mBluetoothAdapter == null) {
        // BLUETOOTH is NOT AVAILABLE
        return false;
    } else {
        if (mBluetoothAdapter.isEnabled())
            // BLUETOOTH is TURNED ON
            return true;
        else 
            // BLUETOOTH is TURNED OFF
            return false;
    }
}