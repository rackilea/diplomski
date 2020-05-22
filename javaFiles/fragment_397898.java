BufferedReader reader = Files.newBufferedReader(path);

String firstLine = reader.readLine();

result = reader.lines()
    .map(something)
    .collect(toList());