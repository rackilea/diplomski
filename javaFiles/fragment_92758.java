public class GameActivity extends Activity {
    private GameMainView gameMainView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameMainView = new GameMainView(this);
        setContentView(gameMainView);
    }
}