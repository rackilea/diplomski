public class MainActivity extends AppCompatActivity {

    private MainLoop mainLoop = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mainLoop == null) {
            mainLoop = new MainLoop();
            mainLoop.start();
        } else {
            System.out.println("onCreate: Thread has not been killed!");
        } 
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mainLoop == null) {
            mainLoop = new MainLoop();
            mainLoop.start();
        } else {
            System.out.println("onResume: Thread has not been killed!");
        } 
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mainLoop != null) {
            mainLoop.kill();
            mainLoop = null;
        } else {
            System.out.println("onTouchEvent: Thread has not been created!");
        }
        return false;
    }