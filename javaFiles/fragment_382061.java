public static String cleanString(String text){
    StringBuilder sb = new StringBuilder("");
    for(int i = 0;i < text.length();i++){
        for (int j = 0; j < validCharsUsername.length; j++) {
            if (validCharsUsername[j] == text.charAt(i)) {
                sb.append(text.charAt(i));
                break;
            }
        }
    }
    return sb.toString();
}