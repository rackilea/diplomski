public class UniqueLineReader extends BufferedReader {
    Set<String> lines = new HashSet<String>();

    public UniqueLineReader(Reader arg0) {
        super(arg0);
    }

    @Override
    public String readLine() throws IOException {
        String uniqueLine;
        while (lines.add(uniqueLine = super.readLine()) == false); //read until encountering a unique line
            return uniqueLine;
    }

    public static void main(String args[]) {
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(
                    "/home/emil/Desktop/ff.txt");
            UniqueLineReader br = new UniqueLineReader(new InputStreamReader(fstream));
            String strLine;
            // Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                    System.out.println(strLine);
            }
            // Close the input stream
            in.close();
        } catch (Exception e) {// Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

    }
}