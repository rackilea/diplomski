public static void main(String[] args) throws UnsupportedEncodingException {

    // default charset
    Charset defaultCharset = Charset.defaultCharset();
    System.out.println("default charset = " + defaultCharset);

    // String sample
    String yourString = "endereço";

    //  getBytes() with default platform encoding
    System.out.println("getBytes() with default charset, size = " + yourString.getBytes().length + System.lineSeparator());

    // getBytes() with specific charset UTF-8
    System.out.println("getBytes(\"UTF-8\"), size = " + yourString.getBytes("UTF-8").length);       
    System.out.println("getBytes(StandardCharsets.UTF_8), size = " + yourString.getBytes(StandardCharsets.UTF_8).length + System.lineSeparator());

    // getBytes() with specific charset UTF-16      
    System.out.println("getBytes(\"UTF-16\"), size = " + yourString.getBytes("UTF-16").length);     
    System.out.println("getBytes(StandardCharsets.UTF_16), size = " + yourString.getBytes(StandardCharsets.UTF_16).length);
}