public class AddAlarm extends Activity {

    EditText txtHour;
    EditText txtMinutes;

    DBHelper dbHelper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addalarm);

        txtHour = (EditText) findViewById(R.id.txtHour);
        txtMinutes = (EditText) findViewById(R.id.txtMinutes);

        dbHelper=new DBHelper(this);

        Button button1 = (Button) findViewById(R.id.addalarmbtn);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btnAddAlarm_Click(v);
            }
        });

    }

    public void btnAddAlarm_Click(View view) {
        boolean ok = true;
        try {

            int hour = Integer.parseInt(txtHour.getText().toString());
            int minutes = Integer.parseInt(txtMinutes.getText().toString());

            Alarm al = new Alarm(hour, minutes);
            Toast.makeText(AddAlarm.this, "ADDED! ", Toast.LENGTH_LONG).show();
            dbHelper.AddAlarm(al);


        } catch (Exception ex) {
            Toast.makeText(AddAlarm.this, "ERROR! ", Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }

    }
}