String regex = "(?<=[\\d])(,)(?=[\\d])";
    Pattern p = Pattern.compile(regex);
    String str = "Your input";
    Matcher m = p.matcher(str);
    str = m.replaceAll("");
    System.out.println(str);