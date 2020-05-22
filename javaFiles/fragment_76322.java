final String input = "//[delim1][delim2]\n12delim125delim2";
    // split the input string so you will get anything after // and before \n
    // and anything after \n until end of line ($)
    Pattern p = Pattern.compile("^//(.+)\\n(.*)$");
    Matcher m = p.matcher(input);
    if (!m.matches()) {
      System.out.println("Input string not valid");
      return;
    }

    String delimString = m.group(1);
    String searchString = m.group(2);

    // This matches the opening square bracket,
    // then as a capturing group, anything except a closing bracket. 
    // Finally it matches the closing bracket of the delimiter definition.
    Pattern pDelim = Pattern.compile("\\[([^\\]]+)\\]");
    Matcher mDelim = pDelim.matcher(delimString);

    // build a regex for String.split in the format: delim1|delim2|delim3|...
    String delimiters = "";
    while (mDelim.find()) {
     delimiters += (Pattern.quote(mDelim.group(1)) + "|");
    }
    delimiters = delimiters.substring(0, delimiters.length()-1);

    // split string and convert numbers to integers, then sum them up
    String[] numStrings = searchString.split(delimiters);
    int sum = 0;
    for (String num : numStrings) {
      sum += Integer.parseInt(num);
    }

    System.out.println("Sum: " + sum);