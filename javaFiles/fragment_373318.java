private static String[] parseQuotedData(String dataString) {
    // Make sure there is an even number of double-quotes...
    if (((dataString.length() - dataString.replace("\"", "").length()) & 1) != 0) { 
        // No...so inform User (via console window) and Exit method.
        System.out.println("\u001B[31m*** ERROR! ***\n\u001B[31mDouble-Quote Pairs "
                + "Mismatch In Supplied Data String!\nData String: \u001B[34m" + 
                dataString + "\n");
        return null;
    }

    // Remove whitespaces from Data String.
    dataString = dataString.replace(" ", "");

    // Split (parse) the data string at each double-quote
    // into an array named ss ...
    String[] ss = dataString.split("\"");

    // Declare a result string to return from this method and
    // initialize it with the first element from our parsed 
    // data string. 
    String res = ss[0];

    // Iterate through the remainder of the split data and 
    // deal with the commas contained between double-quotes.
    for (int i = 1; i < ss.length; i++) {
        if (ss[i].equals("") || ss[i].equals(",")) { res+= ss[i]; }
        else { res+= ss[i].replace(",", "-"); }

    }

    // Delete the following if you don't want it...
    System.out.println("My Result String:  \u001B[34m" + res);

    // Parse and return data...
    String[] parsedData = res.split(",");
    return parsedData;
}