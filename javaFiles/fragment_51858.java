public class Test
{
   public static void main(String[] args)
   {
      String str = "test|pipe|delimeter";
      String [] tmpAr = str.split("\\|");

      for(String s : tmpAr)
      {
         System.out.println(s);
      }
   }
}