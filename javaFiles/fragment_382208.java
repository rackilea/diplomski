//this is the url, it can be any of the 3 variants 
    String s = "https://www.google.co.in/search?q=rest+call+in+java&ie=utf-8&oe=utf-8&gws_rd=cr&ei=BaaMVoLbHIKEuwT_oIQI"; 

    //prepare the regex
    Pattern pattern = Pattern.compile("q=(.*?)(?:&|$)");
    Matcher matcher = pattern.matcher(s);

    //extract and decode
    String q = matcher.find() ? URLDecoder.decode(matcher.group(1)) : "";