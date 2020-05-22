String line;
while ((line = scanner.nextLine()) != null) {
    Word word = map.get(line);
    if (word === null) {
        word = new Word(line);
        map.put(line, word);
    }
    word.counterIncrease();
}