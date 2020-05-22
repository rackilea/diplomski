public static boolean isPalindrome(String str) {

  str = str.toLowerCase();
  str = str.replaceAll(" ", "");
  str = str.replaceAll("[^a-zA-Z ]", "");
  System.out.println(str);
  int len = str.length();
  int i, j;

  j = len - 1;

  for (i = 0; i <= (len - 1) / 2; i++) {
    if (str.charAt(i) != str.charAt(j)) {
      return false;
    }
    j--;
  }
  System.out.println(str);
  return true;
}