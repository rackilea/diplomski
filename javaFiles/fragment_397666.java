public class MyActivity extends ActionBarActivity {

    private Button myButton;

    public void myFunction(){
        myButton.setText("Java is hard")
    }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        myButton = (Button) findViewById(R.id.designerbutton);
   }