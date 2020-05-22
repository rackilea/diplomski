private void initialize() {
    // TODO Auto-generated method stub
    start = (Button) findViewById(R.id.bSA);
    startFor = (Button) findViewById(R.id.bSAFR);
    sendET = (EditText) findViewById(R.id.etSend);
    gotAnswer = (TextView) findViewById(R.id.tvGot);
    start.setOnClickListener(this);
    startFor.setOnClickListener(this);
}