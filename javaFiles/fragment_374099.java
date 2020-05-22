private void updateTextView() {
    TextView text2;
    double update;
    double rateofPay = 9.00;
    text2 = (TextView)findViewById(R.id.textView2);
    CharSequence newtime = text2.getText();
    double number = Double.parseDouble(newtime.toString());
    update = number+ rateofPay;
    text2.setText(String.valueOf(update));
}