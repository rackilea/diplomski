int lineNumber = 0;
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    int positionNumber = 0;
    for (String word : line.split("\\s")) {
        if (!word.isEmpty())
            System.out.println(word + ": line " + (lineNumber + 1) + ", position " + (positionNumber + 1));
        positionNumber += word.length() + 1;
    }
    lineNumber++;
}