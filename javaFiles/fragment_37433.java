String text =  "<div class=\"aaaa\">1234</div>";
               text +=    "<li class=\"pcs05\">ABCD</li>";
    Pattern p = Pattern.compile("<li class=\"[A-Za-z0-9]+\">(\\S+)</li>");
    Matcher m = p.matcher(text);
    if(m.find()){
        System.out.println(m.group(1));
    }