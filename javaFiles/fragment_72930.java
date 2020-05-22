public static void main(final String[] args) {
    try {
        final BufferedReader reader = new BufferedReader(new FileReader("infile.txt"));
        final PrintWriter writer = new PrintWriter(new File("outfile.txt"));

        String inputLine;

        while((inputLine = reader.readLine()) != null) {
            writer.println(inputLine);
        }

        reader.close();
        writer.close();
    } catch(final Exception e) {
        e.printStackTrace();
    }
}