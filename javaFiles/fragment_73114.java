public static void main(String[] args) {
    String s = startChar("Apple", 'p');
    System.out.println("");
}

public static String startChar(String str, char ch) {
    return startChar(str,ch,"","");
}

private static String startChar(String str, char ch, String acc, String chs) {
    //This if statement details the end condition
    if (str.length() < 1) {
        return chs + acc;
    }


    String newString = str.substring(1); //Create new string without first character

    if(str.charAt(0) == ch) { //This happens when your character is found
        return startChar(newString, ch,acc, chs + ch);
    } else { //This happens with all other characters
        return startChar(newString, ch,acc+str.charAt(0), chs);
    }
}