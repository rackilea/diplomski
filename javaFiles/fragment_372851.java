public static void splitAndPrintString2(String str) {
    System.out.println("String: " + str + " splits to: ");
    String splitStr[] = str.split("(,')|(, ')");
    for(String s: splitStr) {
        if(s.endsWith("NULL")) {
            String prefix = s.substring(0, s.lastIndexOf(","));
            String suffix = s.substring(s.lastIndexOf(",")+1);
            System.out.println(prefix.replaceAll("'$", ""));
            System.out.println(suffix.replaceAll("'$", ""));
        } else {
            System.out.println(s.replaceAll("'$", ""));
        }
    }
    System.out.println("");
}