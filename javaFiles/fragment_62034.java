BufferedReader reader = new BufferedReader(new FileReader(new File("resources/input.txt")));

String line;

while((line = reader.readLine()) != null) {

    if (line.contains("=")) {
        String[] bits = line.split("=");
        String name = bits[0].trim();
        String value = bits[1].trim();

        if (name.equals("type")) {
            // Make a new object
        } else if (name.equals("year")) {
            // Store in the current object
        }
    } else {
        // It's a new line, so you should make a new object to store stuff in.
    }
}