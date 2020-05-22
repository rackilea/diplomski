public void reverse() {
    if (text.length() <= 1)
        return;

    String firstChar = text.substring(0, 1);

    Sentence rest = new Sentence(text.substring(1));
    rest.reverse();

    text = rest.text.concat(firstChar);
}