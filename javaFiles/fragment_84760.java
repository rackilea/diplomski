public static void main(String... args) {
    String s = "lorem ipsum dolor sit blah $10 bleh";
    System.out.println(s.replaceAll(censorWords("ipsum", "sit", "$10"), "*"));
    // prints "lorem ***** dolor *** blah *** bleh"
}
public static String censorWords(String... words) {
    StringBuilder sb = new StringBuilder();
    for (String w : words) {
        if (sb.length() > 0) sb.append("|");
        sb.append(
           String.format("(?<=(?=%s).{0,%d}).",
              Pattern.quote(w),
              w.length()-1
           )
        );
    }
    return sb.toString();
}