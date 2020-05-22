String xmlTag = "http://www.facebook.com/profile.asp?id=123456789";
    String regexId = "\\?id=(\\d+)";
    final Pattern patternId = Pattern.compile(regexId);
    final Matcher matcherId = patternId.matcher(xmlTag);
    System.out.println("found id = " + matcherId.find());
    System.out.println("id = " + matcherId.group(1));