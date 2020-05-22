private void shuffle(List<Word> words) {
    List<String> meanings = words.stream()
            .map(Word::getMeaning)
            .collect(Collectors.toList());
    Collections.shuffle(meanings);

    for(int i = 0; i < words.size(); i++) {
        words.get(i).setMeaning(meanings.get(i));
    }
}