private String encode(String string) {
    try { 
        byte ptext[] = string.getBytes("ISO-8859-1");
        string = new String(ptext, "UTF-8");   
    }
    catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }     
    return string;      
}