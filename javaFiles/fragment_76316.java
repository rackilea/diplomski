public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }
    @Override
    public void SelfDestruct(View View)
    {
        TextView tx= (TextView) findViewById(R.id.text);
        Random r = new Random();
        int x=r.nextInt(2) + 1;  // r.nextInt(2) returns either 0 or 1
        tx.setText(""+x);  // cast integer to String
    }
}