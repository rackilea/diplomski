List<String> words = new ArrayList<>();
for (String s : keys) {
    String currentWord = s.trim();
    if (!currentWord.equals("")) {
        words.add(currentWord);
    }
}