public String getWord(String word) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == 'o' || word.charAt(i) == 'u') {
            sb.append(word.charAt(i));
        } else if (word.charAt(i) != 'a' && word.charAt(i) != 'e' && word.charAt(i) != 'i') {
            sb.append((i + 1));
        }
    }
    return sb.toString();
}