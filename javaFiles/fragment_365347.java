private static Rule handleRule(String ruleStr) {
    Pattern propertyPattern = Pattern.compile("<[\\w\\d]*\\([<>\\w\\d,]*\\)>");
    String name = ruleStr.substring(0,ruleStr.indexOf('('));
    String params = ruleStr.substring(ruleStr.indexOf('(') + 1, ruleStr.lastIndexOf(')'));
    Matcher matcher = propertyPattern.matcher(params);
    if(!matcher.find())
      throw new IllegalArgumentException();
    Property prop1 = toProp(matcher.group());
    if(!matcher.find())
      throw new IllegalArgumentException();
    Property prop2 = toProp(matcher.group());
    params = params.replaceAll("<[\\w\\d]*\\([<>\\w\\d,]*\\)>","").toLowerCase();
    return new Rule(name,prop1,prop2,params.contains("negative"),params.contains("reversive"));
  }