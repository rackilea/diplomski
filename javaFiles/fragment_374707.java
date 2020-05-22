public class SettingsScreen extends Activity {

private EditText inputTxt1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.screen_settings);
    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    EditText inputTxt1 = (EditText) findViewById(R.id.yourPhoneNum);    
    Button saveBtn1 = (Button) findViewById(R.id.btnSave1);

    saveBtn1.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
          String phoneNum1 = inputTxt1.getText().toString();
          savenum1(phoneNum1);
       }
   });
}

public void savenum1(String phoneNum1) {

    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

    dlgAlert.setMessage("Saved" + phoneNum1);
    //dlgAlert.setPositiveButton("OK", null);
    dlgAlert.setCancelable(true);

    dlgAlert.setPositiveButton("Ok",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
              //dismiss the dialog  
            }
        });    
    dlgAlert.create().show();
}