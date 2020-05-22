@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_monthlycalc);
    bu=(Button)findViewById(R.id.year);
    bu.setOnClickListener(this);
    bu2=(Button)findViewById(R.id.calc);
    bu2.setOnClickListener(this);
    bu3=(Button)findViewById(R.id.reset);
    bu3.setOnClickListener(this);
    bu4=(Button)findViewById(R.id.H1);
    bu4.setOnClickListener(this);
    bu5=(Button)findViewById(R.id.ron);
    on=(EditText)findViewById(R.id.loanAm);
    on2=(EditText)findViewById(R.id.intRate);
    on3=(EditText)findViewById(R.id.lonTerm);
    tex  = (TextView) findViewById(R.id.monPay);
}


@Override
public void onClick(View v)
{
    try {
        num=Integer.valueOf(on.getText().toString().trim());
    } catch (NumberFormatException e) {
        num=0;
    }

    try {
        num2=Integer.valueOf(on2.getText().toString().trim());
    } catch (NumberFormatException e) {
        num2=0;
    }

    try {
        num=Integer.valueOf(on3.getText().toString().trim());
    } catch (NumberFormatException e) {
        num3=0;
    }
    result=num+num2+num3;
    if (v.getId()==R.id.calc)
        tex.setText(String.valueOf(result));    
}