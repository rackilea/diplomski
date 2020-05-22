Pattern p = Pattern.compile("\\s+?(.+?)=\"(.+?)\\s*?\"",Pattern.DOTALL);
    Map a = new HashMap() ;
    Matcher m = p.matcher(s) ;
    while( m.find() ) {
        String key = m.group(1).trim() ;
        String val = m.group(2).trim() ; 
        a.put(key, val) ;
    }