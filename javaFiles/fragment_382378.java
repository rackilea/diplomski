// BufferedReader has a nice readline method which makes
// it easier to read text with.  You could use a Scanner
// but I prefer BufferedReader, but that's me...
try (BufferedReader br = new BufferedReader(new FileReader(new File("...")))) {
    String line = null;
    // Read each line
    while ((line = br.readLine()) != null) {
        // Split the line into individual parts, on the <tab> character
        String parts[] = line.split("\t");
        int sum = 0;
        // Staring from the first number, sum the line...
        for (int index = 1; index < parts.length; index++) {
            sum += Integer.parseInt(parts[index].trim());
        }
        // Store the key/value pairs together some how
    }
}