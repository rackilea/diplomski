EditText editText;
TextView textView;
HorizontalScrollView horizontalScrollView;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =(EditText)findViewById(R.id.editText);
        textView =(TextView)findViewById(R.id.textView);
        horizontalScrollView =(HorizontalScrollView)findViewById(R.id.horizontalScrollView);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(s);
                horizontalScrollView.post(new Runnable() {
                    public void run() {
                        horizontalScrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });               

    }