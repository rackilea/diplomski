public static void charCount(String b) {
   int upper = 0;
   int a = 0;
   for (int i = 0; i < b.length(); i++) {
      char v = b.charAt(i);
      if(v == 'a'  ||  v == 'A')  {
         a++;
      }
      if(Character.isUpperCase(v))  {
         upper++;
      }
   }
   System.out.println("There are " + upper + " upper case letters, and " + a + " lower case a's in the String");
}