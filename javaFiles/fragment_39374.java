while(reader.hasNextLine()) {
    String line = reader.nextLine();
    if (line.matches("\\bARTICLE\\b")) {
        count += 1;
    }
}