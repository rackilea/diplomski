private static final Pattern p = Pattern.compile("'(''|[^'])*'");
public static void main(String[] args) {

    String input = 
              "declare\r\n"
            + "   string varchar(255);\r\n"
            + "begin\r\n"
            + "   string := ''' this is a string ^''^ is the delimiter';\r\n"
            + "   dbms_output.put_line(string);\r\n"
            + "end;";

    Matcher m = p.matcher(input);
    StringBuffer sb = new StringBuffer(input.length());
    int count = 0;
    while (m.find()) {
        m.appendReplacement(sb, "%{" + (++count) + "}s");
    }
    m.appendTail(sb);
    System.out.println(sb.toString());
}