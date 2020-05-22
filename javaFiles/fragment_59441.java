wage = (EditText) findViewById(R.id.wage);
submit.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        String wageText = wage.getText().toString();
        double wageAmount = Double.valueOf(wageText);
        wageAfterTax = wageAmount * 0.25;
        result.setText("Your wage after tax deductions is " + wageAfterTax);
    }
});