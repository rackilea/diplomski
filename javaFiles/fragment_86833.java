String filename = "[filename]";
BufferedReader reader = new BufferedReader(new FileReader(filename));

while (true) {
    String line = reader.readLine();
    if (line != null)
        // Use line
    else {
        reader.close();
        reader = new BufferedReader(new FileReader(filename));
    }
}