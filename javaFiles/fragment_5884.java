@Override
        public void afterTextChanged(Editable s) {
            //CURRENT_ACTION = DEF_____________________________________________

            if((CURRENT_ACTION == DEF) && !textNumber.getText().toString().isEmpty()){
                //store the first number
                number1 = Double.parseDouble(textNumber.getText().toString());
                //display current result : number1
                textResult.setText(String.valueOf(mResult));

            }

            //CURRENT_ACTION = ADD______________________________________________

            else if(CURRENT_ACTION == ADD && !textNumber.getText().toString().isEmpty()){
                //store second number
                number2 = Double.parseDouble(s.toString());
                // display second + first number as result
                textResult.setText(String.valueOf(number1 + number2));
            }


        }
    });