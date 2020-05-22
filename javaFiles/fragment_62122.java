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