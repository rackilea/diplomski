public class MainActivity extends Activity 
{

Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     // You forgot this line
        addListenerOnButton();
    }