CharSequence inputStr = "abcabcab283c";
    String patternStr = "[1-9]{3}";
    Pattern pattern = Pattern.compile(patternStr);
    Matcher matcher = pattern.matcher(inputStr);
    if(matcher.find()){

    System.out.println(matcher.start());//this will give you index
    }