public class GuessOne extends ActionBarActivity {
    int randone;
    int contone;
    Bundle bundle;
    String maxPressed = "";
    int maxcont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_guess_one);

        maxPressed = getIntent().getStringExtra("maxNumberPressed");
        try {
            maxCont = Integer.parseInt(maxPressed);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        } 
    }

    //the rest of the code