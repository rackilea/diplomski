public class SecondActivity extends AppCompatActivity {
    // ...
    BluetoothConnectionService mBluetoothConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // ...

        // get the BluetoothConnectionService instance
        mBluetoothConnection = BluetoothConnectionService.getInstance();
    }

    public void send() {
        // ...
        mBluetoothConnection.write(bytes);
    }
}