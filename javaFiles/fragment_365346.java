public static Fact handleFact(String factStr) {
    Pattern propertyPattern = Pattern.compile("<[\\w\\d]*\\([<>\\w\\d,]*\\)>");
    int s = factStr.indexOf("(") + 1;
    int l = factStr.lastIndexOf(")");
    String name = factStr.substring(0,s-1);
    String params = factStr.substring(s, l);
    Matcher matcher = propertyPattern.matcher(params);
    List<Property> props  = new ArrayList<>();
    while(matcher.find()){
      String propStr = matcher.group();
      props.add(toProp(propStr));
    }
    String[] split = propertyPattern.split(params);
    boolean truth = Boolean.valueOf(split[split.length-1].replaceAll(",","").trim());
    return new Fact(truth,props,name);
  }