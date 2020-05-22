public class My {
    public static void main(String args[]) throws java.io.UnsupportedEncodingException {    
        System.setProperty("file.encoding","UTF-8");
        System.out.println("Default Charset = " + java.nio.charset.Charset.defaultCharset());

        String పేరు = "Yash";
        System.out.println("UNICODE - Identifier[Variable Name] : " + పేరు);

        String hebrew = "יאש";
        System.out.println("UNICODE - Literal[Variable value] : "+ hebrew );

        System.out.println("windows-1255 : " + new String(hebrew.getBytes("UTF-8"), "UTF-8") );
    }   
}