class Palindrome {
  public static String reverse(String s) {
    if ("".equals(s)) {
      return s;
    } else {
      return reverse(s.substring(1,s.length())) + s.charAt(0);
  }
}

  public static void main(String args[]) {
    System.out.print(reverse("galskjdf"));
  }
}