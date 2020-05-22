public String sumToCharsAtString(String word) {
    StringBuffer b = new StringBuffer();
    char[] chars = word.toCharArray();
    for (char c : chars) {
        if(c != ' ')
            c = (char) (c + 1);
        b.append(c);
    }
    return b.toString();
 }