public static void main(String[] args) {
    String wkJsonStr = "\"['MET', 'MISSED']\"";
    System.out.println(wkJsonStr);
    wkJsonStr = wkJsonStr.replaceAll("\"\\[", "[").replaceAll("\\]\"", "]");
    System.out.println(wkJsonStr);
}