public void validate (NumberTextBox actual, NumberTextBox recommended) 
 {
     if(actual.getNumber() <= recommended.getNumber()) {
        actual.setInvalid();
        showErrorWindow();
        throw new NumberFormatException();
     }
 }