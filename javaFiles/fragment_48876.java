public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //HERE <-----

         Intent i = new Intent(MainActivity.this, SecondClass.class);
         startActivity(i);
    }
}