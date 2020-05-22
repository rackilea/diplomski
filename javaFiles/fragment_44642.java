public static void main(String[] args) {
    System.out.println(replaceAll("Hello", '_'));

    String sentence = "Hello Mom What Is For Dinner?";
    StringBuilder sentenceReformed = new StringBuilder();

    for (String word : sentence.split(" ")) {
        sentenceReformed.append(replaceAll(word, '_'));
        sentenceReformed.append(" ");
    }

    System.out.println(sentenceReformed);
}

public static String replaceAll(String word, char replacer) {
    StringBuilder ret = new StringBuilder();
    if (word.length()>2) {
        ret.append(word.charAt(0));
        for (int i = 1; i < word.length() - 1; i++) {
            ret.append(replacer);
        }
        ret.append(word.charAt(word.length() - 1));
        return ret.toString();
    }

    return word;
}