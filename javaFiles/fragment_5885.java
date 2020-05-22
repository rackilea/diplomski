buttonAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CURRENT_ACTION = ADD;
            textNumber.setText(null);
            //get the result and store it as the first number
            //then we will add the second number
            // that will be get from the other part of the code
            //to this first number
            number1 = Double.parseDouble(textResult.getText().toString());
        }
    });