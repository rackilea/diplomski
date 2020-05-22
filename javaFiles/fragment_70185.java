String duplicatePattern = "(?i)\\b(\\w+)\\b[\\w\\W]*\\b\\1\\b";
    Pattern p = Pattern.compile(duplicatePattern);
    String phrase = "this is#$;%@;<>?|\\` p is a is Test\n of duplicate test";
    Matcher m = p.matcher(phrase);
    String val = null;
    while (m.find()) {
        val = m.group();
        System.out.println("Matching segment is \"" + val + "\"");
        System.out.println("Duplicate word: " + m.group(1)+ "\n");
    }