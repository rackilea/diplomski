private static void print(double[] f, double[] convolution, double[] correlation) {
    // Determine which array contains the most elements.
    // We will use that array length for our iteration 
    // ahead.
    int maxArrayLenth = f.length;
    if (convolution.length > maxArrayLenth) { maxArrayLenth = convolution.length; }
    if (correlation.length > maxArrayLenth) { maxArrayLenth = correlation.length; }

    // Determine the location for the start of our header
    // so as to achieve proper right alignment. This means
    // it wont matter how many digits 'i' will contain, the 
    // table will always properly align.
    int hiVal = String.valueOf(f.length).length();

    // Print the Table Header to console...
    String header = String.format("%n%" + hiVal + "s %10s %15s %15s","i", "f(i)", 
                                  "convolution[i]", "correlation[i]");
    System.out.println(header);
    // Print the Table Header Underline to the exact length of our 
    // Table Header. We use the String.join() method in conjuction 
    // with the Collection Class nCopies() method so as to create 
    // a string of "=" characters. We subtract 2 from the header 
    // length because we used the String format's newline (%n) tag
    // to create a blank line before the Header itself for a cleaner
    // display of multiple tables.
    System.out.println(String.join("", Collections.nCopies(header.length() - 2, "=")));

    // Do the iteration through all the arrays using the length
    // based on our largest array.
    for (int i = 0; i < maxArrayLenth; i++) {
        // Convert the Double Data Type element from
        // each array into a String variable. This way
        // if any particular array does not contain a
        // designated index the string for that particular
        // array element will hold "------".
        String strgF; // current element from the f[] Array
        if (i > f.length-1) { strgF = "-------"; }
        // "%.5f" is used in format() to ensure a decimal precison of 5
        else { strgF = String.format("%.5f", f[i]); }

        String conv; // current element from the convolution[] Array
        if (i > convolution.length-1) { conv = "-------"; }
        else { conv = String.format("%.5f", convolution[i]); }

        String corr; // current element from the correlation[] Array
        if (i > correlation.length-1) { corr = "-------"; }
        else { corr = String.format("%.5f", correlation[i]); }

        // Print the current Table Data line...
        System.out.printf("%" + hiVal + "d %10s %15s %15s%n", i, strgF, conv, corr);
    }
}