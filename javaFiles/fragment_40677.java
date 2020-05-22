@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);

textTip = (TextView) findViewById(R.id.tvTip);
textHour = (TextView) findViewById(R.id.tvHour);
textWage = (TextView) findViewById(R.id.tvWage);
editTip = (EditText) findViewById(R.id.etTip);
editHour = (EditText) findViewById(R.id.etHour);

//int tip =  Integer.parseInt((String) textTip.getText());
//int hour = Integer.parseInt((String) textHour.getText());

Button bSubmit = (Button) findViewById(R.id.bSubmit);
bSubmit.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        // TODO Auto-generated method stub
        textTip.setText(editTip.getText());
        textHour.setText(editHour.getText());
        wage = Integer.parseInt(textTip.getText().toString()) / Integer.parseInt(textHour.getText().toString());

            textWage.setText(String.valueOf(wage));
        }
    });
}
}