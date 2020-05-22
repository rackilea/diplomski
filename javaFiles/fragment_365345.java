private static Property toProp(String propStr) {
    String name = propStr.substring(1,propStr.indexOf("("));
    String[] arguments = propStr.substring(propStr.indexOf('(')+1,propStr.indexOf(')')).split(",");
    return new Property(name,
            arguments[0].substring(1,arguments[0].length()-1),
            arguments[1].substring(1,arguments[1].length()-1));
  }