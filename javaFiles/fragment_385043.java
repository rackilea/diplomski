public class HelloThereActivity extends Activity implements View.OnClickListener{
    /** Called when the activity is first created. */
 Button txt;
 Typeface font;
  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       txt = (Button) findViewById(R.id.button1);  

       // call here for setting font 
       setfonttoView(txt);

       //.....same for other buttons
    }
  public void setfonttoView(Button button){
       font = Typeface.createFromAsset(getAssets(), "customfont.ttf");  
       button.setTypeface(font);
    }

  //your code here...