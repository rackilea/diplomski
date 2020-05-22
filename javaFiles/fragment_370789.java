public static void replace() {

    try {
        File file = new File("resources/abc.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "", oldtext = "";
        boolean found = false;
        while ((line = reader.readLine()) != null) {
            if (line.trim().startsWith("<!DOCTYPE Publisher")) {
                found = true;
            }
            if (line.trim().endsWith("A++V2.4.dtd\">")) {
                oldtext += "<!DOCTYPE Publisher>";
                found = false;
                continue;
            }
            if (found) {
                continue;
            }
            oldtext += line + "\n";
        }
        reader.close();

        FileWriter writer = new FileWriter("resources/file.txt");
        writer.write(oldtext);
        writer.close();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
}