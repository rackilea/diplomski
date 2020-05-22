myTextfield.setTextFieldFilter(new TextFieldFilter() {

    // Accepts all Characters except 'a' 
    public  boolean acceptChar(TextField textField, char c) {
         if (c == 'a')
               return false;
         return true;
    }
});