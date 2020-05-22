public static void main(String[] args) {
  String[] words = { "joyful", "great", "excited",
      "happy" };
  java.util.List<String> list1 = java.util.Arrays
      .asList(words);
  String vbl1 = "happy";
  if (list1.contains(vbl1)) {
    System.out.printf("%s contains %s\n",
        java.util.Arrays.toString(words), vbl1);
  } else {
    System.out.printf("%s does not contain %s\n",
        java.util.Arrays.toString(words), vbl1);
  }
}