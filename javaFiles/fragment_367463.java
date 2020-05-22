public class MainActivity extends AppCompatActivity {

    private boolean[] areBothViewsDrawn = {false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text1 = (TextView) findViewById(R.id.text1);
        final TextView text2 = (TextView) findViewById(R.id.text2);

        text1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                text1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                areBothViewsDrawn[0] = true;
                setText2Position(text1, text2);
            }
        });

        text2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                text2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                areBothViewsDrawn[1] = true;
                setText2Position(text1, text2);
            }
        });

    }

    private void setText2Position(TextView text1, TextView text2) {
        if (!areBothViewsDrawn[0] || !areBothViewsDrawn[1])
            return;

        int lineCount = text1.getLayout().getLineCount();
        float lastLineRight = text1.getLayout().getLineRight(lineCount - 1);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) text2.getLayoutParams();
        if (lastLineRight + text2.getWidth() > screenWidth) {
            //The width of the last line of text1 is too long for the text2 to fit, so text2 must be in another line
            params.addRule(RelativeLayout.BELOW, text1.getId());
        } else {
            //The width of the last line of text1 and text2 smaller then the application's width, so text2 can be in the same line as text1
            params.addRule(RelativeLayout.ALIGN_BOTTOM, text1.getId());
        }
    }
}