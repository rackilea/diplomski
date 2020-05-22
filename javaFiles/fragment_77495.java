public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button PressMe = (Button)findViewById(R.id.btnPressMe);
        PressMe.setOnClickListener(new OnClickListener() 
        {
             @Override
             public void onClick(View v) 
            {
                // TODO Auto-generated method stub
                  startActivity(new  Intent(MainActivity.this, PiggyBank.class));
            }
       });
}