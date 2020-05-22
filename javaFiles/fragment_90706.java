String dictionary = "abcdefghijklmnopqrstuvwxyz";
StringBuilder sb = new StringBuilder(input.length());
for (int i = 0; i < input.length(); i++) {
    char oldChar = input.charAt(i);
    int oldCharPositionInDictionary = dictionary.indexOf(oldChar);
    if (oldCharPositionInDictionary >= 0) {
        int newCharPositionInDictionary = 
            (oldCharPositionInDictionary + lag) % dictionary.length();
        sb.append(dictionary.charAt(newCharPositionInDictionary));
    }
    else if (oldChar == ' ') {
        sb.append(' ');
    }
}
String result = sb.toString();