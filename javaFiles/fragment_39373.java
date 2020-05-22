while(reader.hasNextLine()) {
    String line = reader.nextLine();
    if (line.contains("ARTICLE")) {
        count += 1;
    }
}