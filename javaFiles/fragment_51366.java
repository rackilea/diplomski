public class MainActivity extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    // Settings button start   
    Button settingsButton = (Button) findViewById(R.id.btnSettings);
    settingsButton.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
          startSettings();
       }
   });
   Button setAButton = (Button) findViewById(R.id.btnSetA);
   setAButton.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View view) {
         setzoneA(); 
      } 
   });
   // Set B Button start
   Button setBButton = (Button) findViewById(R.id.btnSetB);
   setBButton.setOnClickListener(new OnClickListener(){
      @Override
      public void onClick(View view) {
          setzoneB(); 
      }  
   });
}

public void startSettings() {
   Intent launchSettings = new Intent(this, SettingsScreen.class);
   startActivity(launchSettings);     
}

public void setzoneA() {

    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
    dlgAlert.setMessage("Zone Set");
    dlgAlert.setPositiveButton("OK", null);
    dlgAlert.setCancelable(true);
    dlgAlert.create().show();

    dlgAlert.setPositiveButton("Ok",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
              //dismiss the dialog  
            }
        });       
}


public void setzoneB()  {

   AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

   dlgAlert.setMessage("Zone Set");
   dlgAlert.setPositiveButton("OK", null);
   dlgAlert.setCancelable(true);
   dlgAlert.create().show();

   dlgAlert.setPositiveButton("Ok",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
              //dismiss the dialog  
            }
        });
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
   // Inflate the menu; this adds items to the action bar if it is present.
   getMenuInflater().inflate(R.menu.main, menu);
   return true;
}