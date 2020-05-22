public static void main (String[] args) {
    String input= "(2 h 9 min from now) | +18.7 feet";
    System.out.println("Input: "+ input);
    Pattern p = Pattern.compile("\\(([^)]+)\\) \\| \\+(\\d+\\.\\d feet)");
    Matcher m = p.matcher(input);
    String a = null, b = null;
    if (m.find()) {
        a = m.group(1);
        b = m.group(2);
    }
    System.out.println("a: "+ a);
    System.out.println("b: "+ b);
}