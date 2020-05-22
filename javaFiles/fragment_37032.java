public class DynamicEvents extends Activity
   {
     protected void onCreate(Bundle savedInstanceState)
     {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.mylayout);
           Bundle b = getIntent().getExtras();
           Meeting meeting = b.getParcelable("my meeting");   
     } 
   }