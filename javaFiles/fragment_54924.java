public void onClick(View v) {
        if(!valueOne.getText().toString().equals("")) {
            num1 = Double.parseDouble(valueOne.getText().toString());
            // result.setText(Double.toString(Double.parseDouble(valueOne.getText().toString()) + Double.parseDouble(valueTwo.getText().toString())));
        } else {
              Toast.makeText(AdditionActivity.this, "Please add some nunber to continue", Toast.LENGTH_LONG).show();
        }

}