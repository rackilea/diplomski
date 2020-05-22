String yourString = "<envelope><body><entity1></entity1></body></envelope>";
    String REGULAR_EXPRESSION= "(\\<body>.+?\\</body>)";
    Pattern pattern = Pattern.compile(REGULAR_EXPRESSION, Pattern.DOTALL | Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(hello);
    if (matcher.find()) {
       System.out.println(yourString.replaceAll(matcher.group(1), ""));
    }