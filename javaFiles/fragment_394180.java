public String censured(String input){

    char[] c= input.toCharArray();

    String censured ="";
    for (int i = 0; i < c.length; i++) {
            if(c[i] == ' ' ) censured += " ";
            if(c[i] == ',') censured += c[i];
            if(c[i] != ' ' && c[i] != ',') censured += "x";
    }
    return censured;
}