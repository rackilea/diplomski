public static StringBuffer createEncodedSentence(String sentence) {

    StringBuffer buff = new StringBuffer();
    int counter = 0;
    char a;

    for (int i = 0; i < sentence.length(); i++) {
        a = sentence.charAt(i);
        if (a == '.') {
            buff.append("*");
            continue;
        }
        if ((i + 1) % 3 == 0 && a != ' ' && a != '.') {
            counter++;
            continue;
        }
        buff.append(sentence.charAt(i));
    }
    buff.append(counter);
    return buff;

}