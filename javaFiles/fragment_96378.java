public class SpanTest extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String dispStr = "This has the string ABCDEF in it \nSo does this :ABCDEF - see!\nAnd again ABCD here";
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(dispStr);
        changeTextinView(tv, "ABC", Color.RED);
    }

    private void changeTextinView(TextView tv, String target, int colour) {
        String vString = (String) tv.getText();
        int startSpan = 0, endSpan = 0;
        Spannable spanRange = new SpannableString(vString);

        while (true) {
            startSpan = vString.indexOf(target, endSpan);
            ForegroundColorSpan foreColour = new ForegroundColorSpan(colour);
            // Need a NEW span object every loop, else it just moves the span
            if (startSpan < 0)
                break;
            endSpan = startSpan + target.length();
            spanRange.setSpan(foreColour, startSpan, endSpan,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        tv.setText(spanRange);
    }

}