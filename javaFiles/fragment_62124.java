import java.io.*;

public class Example
{
    private String sourceFileName;
    private String destFileName;

    public static void main (String[] args) throws java.lang.Exception
    {
        try {
            new Example(args[0], args[1]).process();
        }
        catch (ArrayIndexOutOfBoundsException npe) {
            // This is a bit of an exaggeration, I'd check in advance, since the user not
            // supplying arguments isn't really an "exceptional" condition.
            System.out.println("Usage: java Example [source file name] [dest file name]");
        }
    }

    public Example(String src, String dest) {
        // Similar, these checks would probably be assertions, but I'm making a point...
        if (src == null || src.length() == 0) {
            throw new IllegalArgumentException("src must be non-null and non-blank");
        }
        if (dest == null || dest.length() == 0) {
            throw new IllegalArgumentException("dest must be non-null and non-blank");
        }
        this.sourceFileName = src;
        this.destFileName = dest;
    }

    private void process() {
        try (                                                // <== Main logic
            Reader fr = new FileReader(this.sourceFileName); // <== Main logic
            BufferedReader br = new BufferedReader(fr);      // <== Main logic
            Writer fw = new FileWriter(this.destFileName);   // <== Main logic
            BufferedWriter bw = new BufferedWriter(fw)       // <== Main logic
            ) {                                              // <== Main logic
            String line;                                     // <== Main logic
            while ((line = br.readLine()) != null) {         // <== Main logic
                if (shouldIncludeLine(line)) {               // <== Main logic
                    line = transformLine(line);              // <== Main logic
                    bw.write(line);                          // <== Main logic
                    bw.newLine();                            // <== Main logic
                }                                            // <== Main logic
            }                                                // <== Main logic
        }
        catch (FileNotFoundException fnfe) {                 // <== Error handling
            // Couldn't find a file                          // <== Error handling
            // (handle it)                                   // <== Error handling
        }                                                    // <== Error handling
        catch (IOException ioe) {                            // <== Error handling
            // I/O error                                     // <== Error handling
            // (handle it)                                   // <== Error handling
        }                                                    // <== Error handling
        catch (Exception e) {                                // <== Error handling
            // Something else went wrong                     // <== Error handling
            // (handle it)                                   // <== Error handling
        }                                                    // <== Error handling
    }

    private boolean shouldIncludeLine(String line) {
        return line.length() != 0;
    }

    private String transformLine(String line) {
        return line.toUpperCase();
    }
}