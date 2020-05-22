String currentString = "";
try
    {
        currentString = num1Str;
        num1Convert = Integer.parseInt(num1Str);
        currentString = num2Str;
        num2Convert = Integer.parseInt(num2Str);

        sumValue = num1Convert + num2Convert;
        sumLabel.setText(sumText + Integer.toString(sumValue));
    }
    catch(NumberFormatException nfe)
    {
       // errorLabel.setText((HERE IS WHERE I NEED TO PUT CODE TO SAY WHICH TEXTFIELD IT IS" must be an integer");
       errorLabel.setText(currentString + " must be an integer");
        num1.requestFocus();

    }