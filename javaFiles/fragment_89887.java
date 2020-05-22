public static String makeStringEqual(String str, String keyword) {
    StringBuilder sb = new StringBuilder("");
    if (str.length() > keyword.length()) {

        int j = 0; // this tells you what is the current index for the keyword
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) == ' ') {
                sb.append(' ');
            } else {
                sb.append(keyword.charAt(j));

                // when you use up a keyword's character, move on to the next char
                j++;

                // make sure to loop back to the start when you're at the end
                j %= keyword.length();
            }
        }
    }
    return sb.toString();
}