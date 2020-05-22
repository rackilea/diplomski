public static void main(String[] args) {
   String str1 = "12444423100000123       123456 5147894269       123456        TEST PR/123/12/11/1/01 D222";
   String str2 = "12534223100000123       765432 5147124269       124541        PR/123/12/11/1/01      D111";

   String patt = "(\\d{17})\\s+(\\d{6})\\s+(\\d{10})\\s+(\\d{6})\\s+((\\s|\\w)*\\/((\\d{1,3}\\/?)*\\d{1,3}))\\s+(\\w\\d{3})"
   Pattern p = Pattern.compile(patt);

   for (String s : Arrays.asList(str1, str2) {
      Matcher m = p.matcher(s);
      if (m.find()) {                       // for str1               // str2
         System.out.println(m.group(1));   // 12444423100000123       // 12534223100000123
         System.out.println(m.group(2));   // 123456                  // 765432
         System.out.println(m.group(3));   // 5147894269              // 5147124269
         System.out.println(m.group(4));   // 123456                  // 124541
         System.out.println(m.group(5));   // TEST PR/123/12/11/1/01  // PR/123/12/11/1/01
         System.out.println(m.group(9));   // D222                    // D111
      }
      System.out.println();
  }
}