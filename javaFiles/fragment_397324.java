button.setOnClickListener(                 //onButtonClick
       new Button.OnClickListener() {
              public void onClick(View v)
              {
                  //Get selected (shown) value in Spinners and store them in String variables
                  String string1 = Spinner1.getSelectedItem().toString();
                  String string2 = Spinner2.getSelectedItem().toString();

                 //Assign these values to BigDecimal variables
                  BigDecimal num1 = new BigDecimal(string1);
                  BigDecimal num2 = new BigDecimal(string2);

                  //Perform your operation
                  num1.multiply(num2);

                  //Since you haven't told what the usage of the result is, I'll leave it to you
                  //To get value of result (num1) do --> num1.toString();
        }
});