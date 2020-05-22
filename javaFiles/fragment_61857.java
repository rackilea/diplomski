String string = "a b c 1 225 {@x anything = here1} test test {@x bl** #abla} xyz test {@x any characters here}";        
    String regexp = "(\\{\\@x ([^\\{]*)\\})";
    Pattern pattern = Pattern.compile(regexp);
    Matcher matcher = pattern.matcher(string);
    while (matcher.find()){
        System.out.println(matcher.group(2));
    }