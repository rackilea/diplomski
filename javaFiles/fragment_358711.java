CharSequence chars = "1+2-3";

for(int i = 0; i < chars.length(); i++ ) {
    if (Character.isDigit(chars.charAt(i))) {
        //is digit
    } else {
        //is operator
    }
}