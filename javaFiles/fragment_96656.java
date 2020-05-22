private Button send;
private TextView max;
private EditText msg;

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

     max = (TextView) findViewById(R.id.max);
    send = (Button) findViewById(R.id.send);

    msg = (EditText) findViewById(R.id.msg);
    msg.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            max.setText(String.valueOf(140- (msg.getText().toString().length())));
            if(msg.getText().toString().length()>=140){

                send.setEnabled(false);


            }else
                send.setEnabled(true);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });

}


@Override
public void onClick(View view) {
}