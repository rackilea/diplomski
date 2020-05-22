public class MainActivity extends ActionBarActivity {

int width, height;
LinearLayout linearLayout;
Button button;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    linearLayout = (LinearLayout) findViewById(R.id.ll);
    linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            Log.v(getClass().getSimpleName(), "onGlobalLayout");
            width = linearLayout.getWidth();
            height = linearLayout.getHeight();

            placeButton();

            if (Build.VERSION.SDK_INT >= 16) {
                linearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                linearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    });

    button = (Button) findViewById(R.id.button);
}

private void placeButton() {
    Log.v(getClass().getSimpleName(), "width: " + width + " Height: " + height);
    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();

    Random rand = new Random();

    params.leftMargin = rand.nextInt(width);
    params.topMargin = rand.nextInt(height);

    Log.v(getClass().getSimpleName(), "left: " + params.leftMargin + " top: " + params.topMargin);
    button.setLayoutParams(params);
    button.invalidate();
}