public class UniqueLineReader extends BufferedReader {
    Set<String> lines = new HashSet<String>();

    public UniqueLineReader(Reader arg0) {
        super(arg0);
    }

    @Override
    public String readLine() throws IOException {
        String uniqueLine;
        if (lines.add(uniqueLine = super.readLine()))
            return uniqueLine;
        return "";
    }

  //for testing.. 

    public static void main(String args[]) {
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(
                    "test.txt");
            UniqueLineReader br = new UniqueLineReader(new InputStreamReader(fstream));
            String strLine;
            // Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                if (strLine != "")
                    System.out.println(strLine);
            }
            // Close the input stream
            in.close();
        } catch (Exception e) {// Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

}