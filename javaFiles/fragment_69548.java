String id;
    String mailToString; 
    Pattern p = Pattern.compile("Message-ID: <(.*)>");
    Matcher m = p.matcher(mailToString);
    if(m.find()){
        id =  m.group();
    }