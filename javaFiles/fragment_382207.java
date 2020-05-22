//this is the url, it can be any of the 3 variants 
    String s = "https://www.google.co.in/search?q=rest+call+in+java&ie=utf-8&oe=utf-8&gws_rd=cr&ei=BaaMVoLbHIKEuwT_oIQI";

    //find the beginning of the searched term 
    int i = s.indexOf("q=");

    //find the end of the searched term
    int j = s.indexOf("&", i);
    j = j == -1 ? s.length() : j;

    //extract the searched term and decode
    String q = URLDecoder.decode(s.substring(i + 2, j));