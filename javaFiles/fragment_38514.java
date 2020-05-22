try {
    Float num1=Float.parseFloat(num1text.getText().toString());
    Float num2=Float.parseFloat(num2text.getText().toString());
    Float answ = (num1 * num2) / 100;
    TextView answer=(TextView)findViewById(R.id.ans);
    answer.setText(answ);
} catch (NumberFormatException e) {
    TextView answer=(TextView)findViewById(R.id.ans);
    answer.setText("Message");
}