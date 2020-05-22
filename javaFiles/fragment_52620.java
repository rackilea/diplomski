String pre = "ORDER WILL SHIP ";
    String suf = " WORKING DAYS";
    String output = testSequence.substring(testSequence.indexOf(pre) + pre.length(), testSequence.indexOf(suf));
    // remove linebreaks
    output = output.replaceAll("\n", "");
    // Remove "_" in front and after the digit.
    if (output.startsWith("_") && output.endsWith("_")) {
        // Before (example): output = "_5_"
        output = output.substring(1, output.length() - 1);
        // After (example): output = "5"
    }
    int num = Integer.parseInt(output);