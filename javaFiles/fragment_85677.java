public class hello extends Activity 
{   
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toast.makeText(getBaseContext(), "Hello........", Toast.LENGTH_LONG).show();
    }
}