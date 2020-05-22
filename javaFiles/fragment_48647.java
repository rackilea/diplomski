String val="Big Cat eats at 3:49 AM and the Big Dog eats  Daily (BBB) , On 12 at 11:00 AM done";
    String REGEX="(?:Dog[a-zA-Z0-9(),])*([0-9]?[0-9]:[0-9]?[0-9] (AM|PM))(?=\\sdone)";

    Pattern pattern = Pattern.compile(REGEX);
    Matcher matcher = pattern.matcher(val);
    while(matcher.find()){
        System.out.println(matcher.group());
    }