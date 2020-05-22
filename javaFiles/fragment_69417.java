public class LoginMain extends AppCompatActivity {
    RelativeLayout loginMain;
    Random rand = new Random();
    public static int bgPick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        this.bgPick = rand.nextInt(5) + 1; //distribute int from 1 to 3
        //must be called after the content view is set.
        loginMain = (RelativeLayout) findViewById(R.id.activity_login_main);
        randomBG();
    }

    public static int getBgPick(){
        return bgPick;
    }
}