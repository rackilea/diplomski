public static void sort(String myString) {

   String noPuncs = myString.replaceAll("\\W", "");

   char[] chars = noPuncs.toCharArray();
   Arrays.sort(chars);
   System.out.println(chars);

} }