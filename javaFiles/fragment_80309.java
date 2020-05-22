public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private BluetoothConnectionService mBluetoothConnection;

    public void startBTConnection(BluetoothDevice device, UUID uuid){
        Log.d(TAG, "startBTConnection: Initializing RFCOM Bluetooth Connection.");
        if (mBluetoothConnection != null) {
            // connect client
            mBluetoothConnection.startClient(device, uuid);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // ...
        //create the bond.
        //NOTE: Requires API 17+? I think this is JellyBean
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2){
            // ...

            // get the BluetoothConnectionService instance
            mBluetoothConnection = BluetoothConnectionService.getInstance();

            // need to set Context to use ProgressDialog.
            mBluetoothConnection.setContext(getApplicationContext());
        }
    }
}