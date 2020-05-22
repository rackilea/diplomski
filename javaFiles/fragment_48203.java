try(BufferedReader reader = Files.newBufferedReader(path)) {
    int lineIndex = 0;
    String line;
    while(!(line = reader.readLine()).contains(match)) {
        lineIndex++;
    }
    System.out.println(lineIndex); // line which contains match, 0-indexed
    System.out.println(line.indexOf(match)); // starting position of match in line, 0-indexed
}