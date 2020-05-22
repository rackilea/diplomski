public static void main(String[] args) throws Exception {
    String arg = "\\44"; // simulate command line
    String argOctal = arg.substring(1); // get rid of leading \ to get an octal integer
    int codePoint = Integer.parseInt(argOctal, 8);
    System.out.println('\44');
    System.out.println((char)codePoint);
}