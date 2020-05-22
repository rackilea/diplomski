public class ConnectAPRS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_aprs);

        final EditText  callsign = (EditText)   findViewById(R.id.callsign);
        final EditText  passcode = (EditText)   findViewById(R.id.passcode);
        final CheckBox  licensed = (CheckBox)   findViewById(R.id.licensed);

        final Button    bConnect = (Button)     findViewById(R.id.bConnect);

        bConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (licensed.isChecked())
                    startActivity(new Intent(ConnectAPRS.this, Contacts.class));
                else
                    new AlertDialog.Builder(ConnectAPRS.this)
                            .setTitle("ERROR")
                            .setMessage("You are not a licensed operator")
                            .show();
            }
        });
    }
}