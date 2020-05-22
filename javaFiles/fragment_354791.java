public class MainActivity extends Activity {
    BluetoothService mBluetoothService = new BlueToothService(this);

    Nmea mNmea = new Nmea(mBluetoothService);

    Gps mGps = new Gps(mNmea);     
}