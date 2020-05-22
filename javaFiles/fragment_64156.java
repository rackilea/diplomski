if(identityText.matches(MATCH_USER_DOMAIN_PORT)){                                
     Pattern p = Pattern.compile(MATCH_USER_DOMAIN_PORT);
     Matcher m = p.matcher(identityText);
     while(m.find()){
        user = m.group(1);
        domain= m.group(2);
        port= m.group(3);
    }
}