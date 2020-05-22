public static String chrToLast(String str, char ch) {
    //This if statement details the end condition
    if(str.length() < 1) {
        return "";
    }

    String newString = str.substring(1); //Create new string without first character

    if(str.indexOf(ch) == 0) { //This happens when your character is found
        return chrToLast(newString, ch) + ch;
    } else { //This happens with all other characters
        return str.charAt(0) + chrToLast(newString, ch);
    }
}