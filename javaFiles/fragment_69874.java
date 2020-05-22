public class MainActivity extends ActionBarActivity {

public static int homeGoalsCounter ;
public static int homePointsCounter;
public static int awayGoalsCounter;
public static int awayPointsCounter;


protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    homeGoalsCounter = 0;
    homePointsCounter = 0;
    awayGoalsCounter = 0;
    awayPointsCounter = 0;

    }
}