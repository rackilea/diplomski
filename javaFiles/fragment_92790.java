// your outer loop iterating over each line of your input file

while ((line = reader.readLine()) != null) {

    // writing a new String representing the line read from the
    // original,
    // but replacing each of its alphabetic characters (through regex)
    // with an empty String
    writer.write(line.replaceAll("\\p{Alpha}", ""));
}