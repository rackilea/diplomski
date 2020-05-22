public static void main(String[] args){ 
    String unicode = "\u0048\u006C";
    String result = StringEscapeUtils.unescapeJava(unicode); 
    System.out.println(result.charAt(0)); 
    System.out.println(result.charAt(1)); 
}