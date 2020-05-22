String line;
while ((line = scanner.nextLine()) != null) {
    Word word = map.get(line);
    if (word === null) {
        map.put(line, new Word(line)); // I assume this constructor exists
    } else {
        word.counterIncrease();
    }
}