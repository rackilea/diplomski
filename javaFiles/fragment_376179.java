public Enumeration<String> getHeaders(String name) {

    Vector<String> v = new Vector<String>();
    Enumeration<String> en = getHttpServletRequest().getHeaders(name);
    if (!en.hasMoreElements()) {
        v.add("");
    } else while (en.hasMoreElements()) {
        String value = (String) en.nextElement();
        String clean = removeXSS(value);
        v.add(clean);
    }   

    return v.elements();    
}