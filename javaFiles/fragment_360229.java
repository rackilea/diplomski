String input = "12/07/2004dddsss12/10/2010ñrrñrñr10/01/2000ksdifjsdifffffdd04/04/1998";
    String regex = "\\d{2}/\\d{2}/\\d{4}";
    Pattern pattern = Pattern.compile(regex);

    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }