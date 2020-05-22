public class MainActivity extends AppCompatActivity
{
   private TextView themessage;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       themessage = (TextView) findViewById(R.id.message);
   }

   public void doit (View v)
   {
       themessage.setText("Well clicked, Sir!");
   }

   public void starit (View v)
   {
       themessage.setText("****");
   }
}