private void myMethod() {
    String integers = "";
    String characters = "";
    String splitArgument = ""; //this is the 1d or 11d part
    for(int x = 0; x < splitArgument.length(); x++) {
        Char currentChar = splitArgument.charAt(x);
        if(Character.isDigit(currentChar)) {
            integers += currentChar;
        }else {
            characters += currentChar;
        }
    }
}