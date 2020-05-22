// THIS IS FAKE, PSEUDO-JAVA
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