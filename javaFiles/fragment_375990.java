@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.helloworld);
        Spannable spannableString = new SpannableString(getString(R.string.hello_world));        
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), 5, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);

    }