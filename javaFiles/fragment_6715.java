public class MainActivity extends ActionBarActivity {

    static int nasc;
    static int mortes;
    static int popTotal;
    TextView view;
    Handler handler;
    Boolean menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nasc = 0;
        mortes = 0;
        popTotal = 0;
        view = (TextView) findViewById(R.id.text);
        menu = false;
        handler = new Handler();
        handler.postDelayed(updateText, 1000);
    }

    public Runnable updateText = new Runnable() {
        @Override
        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append("Births : " + getNasc() + ".");
            sb.append("\n");
            sb.append("Deaths : " + getMortes() + ".");
            sb.append("\n");
            sb.append("Total Population : " + getPopTotal() + ".");

            view.setText(sb.toString());

            if (menu == false){
                handler.postDelayed(this, 1000);
            }
        }
    };

    //.................