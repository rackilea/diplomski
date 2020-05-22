BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
String line;
long total = 0;
while ((line = reader.readLine()) != null) {
    String[] tokens = line.split(" ");
    if (tokens[0].equals("2"))
        sum += Long.valueOf(tokens[1]);
}