public static void main(String[] args) {
         CSSParser cssParser =  new com.sun.javafx.css.parser.CSSParser();
         Stylesheet s = cssParser.parse("#the\\.button {\n" +
"    -fx-graphic: url(\"Keyboard.png\");\n" +
"}\n" +
"\n" +
"#thebutton {\n" +
"    -fx-graphic: url(\"Keyboard.png\");\n" +
"}");
         System.out.println(""); //add a breakpoint here
    }