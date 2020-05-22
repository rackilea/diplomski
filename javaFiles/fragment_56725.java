private Toolbar toolbar;        

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    toolbar = (Toolbar) findViewById(R.id.tool_bar); 
    setSupportActionBar(toolbar);                   

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}
//Try putting one here } OR (see bottom)
public class MyAndroidAppActivity extends Activity {

 Button button;

 @Override
 public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

     addListenerOnButton();

 }

 public void addListenerOnButton() {

     button = (Button) findViewById(R.id.button_Red);

     button.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View arg0) {

             Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yahoo.com"));
             startActivity(browserIntent);
         }

     });

     button = (Button) findViewById(R.id.button_Blue);

     button.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View arg0) {

             Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
             startActivity(browserIntent);
         }

     });

 }
}

//Or here }