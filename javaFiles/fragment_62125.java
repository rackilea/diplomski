// THIS IS FAKE, PSEUDO-JAVA WITHOUT EXCEPTIONS, IT ISN'T REAL
import java.io.*;

public class Example
{
    private String sourceFileName;
    private String destFileName;

    private enum Errors {
        Success,
        CantOpenSource,
        CantOpenDest,
        CantRead,
        CantWrite
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        if (args.length < 2) {
            System.out.println("Usage: java Example [source file name] [dest file name]");
        }
        if (args[0] == null || args[0].length() == 0) {
            throw new IllegalArgumentException("src must be non-null and non-blank");
        }
        if (args[1] == null || args[1].length() == 0) {
            throw new IllegalArgumentException("dest must be non-null and non-blank");
        }
        switch (new Example(args[0], args[1]).process()) {
            case Errors.CantOpenSource:
                // Handle it
                break;
            case Errors.CantOpenDest:
                // Handle it
                break;
            case Errors.CantRead:
                // Handle it
                break;
            case Errors.CantWrite:
                // Handle it
                break;
        }
    }

    public Example(String src, String dest) {
        // Not how now this constructor is trusting that it is called with valid arguments
        this.sourceFileName = src;
        this.destFileName = dest;
    }

    private Errors process() {
        Reader fr = new FileReader(this.sourceFileName);            // <== Main logic
        if (fr == null) {                                           // <== Error handling
            return Errors.CantOpenSource;                           // <== Error handling
        }                                                           // <== Error handling
        BufferedReader br = new BufferedReader(fr);                 // <== Main logic

        Writer fw = new FileWriter(this.destFileName);              // <== Main logic
        if (fw == null) {                                           // <== Error handling
            br.close();                                             // <== Error handling
            return Errors.CantOpenDest;                             // <== Error handling
        }                                                           // <== Error handling
        BufferedWriter bw = new BufferedWriter(fw)                  // <== Main logic

        String line;                                                // <== Main logic
        while ((line = br.readLine()) != IO.END_OF_FILE) {          // <== Main logic
            if (line == null) {                                     // <== Error handling
                br.close();                                         // <== Error handling
                bw.close();                                         // <== Error handling
                return Errors.CantRead;                             // <== Error handling
            }
            if (shouldIncludeLine(line)) {                          // <== Main logic
                line = transformLine(line);                         // <== Main logic
                if (bw.write(line) == -1 || bw.newLine() == -1) {   // <== Main logic (plus some error handling)
                    br.close();                                     // <== Error handling
                    bw.close();                                     // <== Error handling
                    return Errors.CantWrite;                        // <== Error handling
                }
            }
        }

        bw.close();
        br.close();
        return Errors.Success;
    }

    private boolean shouldIncludeLine(String line) {
        return line.length() != 0;
    }

    private String transformLine(String line) {
        return line.toUpperCase();
    }
}