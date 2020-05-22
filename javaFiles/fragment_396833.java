public class Main extends Activity {

    int count = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView) findViewById(R.id.txtCount);
        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btnReset).setOnClickListener(this);
    }

    private void updateText() {
        String text = Integer.toString(count);
        textView.setText(text);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
        case R.id.btnPlus:
            count++;
            break;
        case R.id.btnMinus:
            count--;
            break;
        case R.id.btnReset:
            count = 0;
            break;
        }

        updateText();
    }
}