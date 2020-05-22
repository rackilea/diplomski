public void printStrings(String... strings)
{
   // the strings parameter is really a String[].
   // You could do anything to it that you normally
   // do with an array.
   for(String s : strings){
      System.out.println(s);
   }
}