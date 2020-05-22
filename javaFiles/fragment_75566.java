public List<String> getWords(String phrase) {
    LetterCounter subList = new LetterCounter(phrase);
    if (phrase == null) throw new IllegalArgumentException();
     List<String> str = new List<>();
    for (String element : dict) {
        if (subList.contains(element))
            str.add(element);
    }
    return str;
}