String ex = "<Condition1>";
while ((line = br.readLine()) != null) {
    // If this is the line we want to insert before...
    if (line.startsWith(ex)) {
        String b = "\n" +
                   "<AdditionalECUVariables>" +
                   "var_3\n" +
                   "var_4\n" +
                   "var_5\n" +
                   "var_6\n";
        // Write out our added data.
        bw.write(b);
    }
    // Always write out the line itself.
    bw.write(line);
}