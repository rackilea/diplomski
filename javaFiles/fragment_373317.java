// Make sure there is an even number of double-quotes...
if (((dataString.length() - dataString.replace("\"", "").length()) & 1) != 0) { 
    // No...so inform User (via console window) and Exit method.
    System.out.println("\u001B[31m*** ERROR! ***\n\u001B[31mDouble-Quote Pairs "
            + "Mismatch In Supplied Data String!\nData String: \u001B[34m" + 
            dataString + "\n");
    return null;
}