public static void main(String[] args) {
    String s = "Hello\\xF6\\xE4\\xFC\\xD6\\xC4\\xDC\\xDF\\xFF ";

    StringBuffer sb = new StringBuffer();
    Pattern p = Pattern.compile("\\\\x[0-9A-F]+");
    Matcher m = p.matcher(s);
    while(m.find()){           
        String hex = m.group();            //find hex values            
        int    num = Integer.parseInt(hex.replace("\\x", ""), 16);  //parse to int            
        char   bin = (char)num;            // cast int to char
        m.appendReplacement(sb, bin+"");   // replace hex with char         
    }
    m.appendTail(sb);
    System.out.println(sb.toString());
}