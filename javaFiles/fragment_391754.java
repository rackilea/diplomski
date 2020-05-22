public class Version
{
   public final static int MAJOR    = 1;
   public final static int MINOR    = 0;
   public final static int PATCH    = 0;

   public final static String VERSION_STRING = MAJOR + "." + MINOR + "." + PATCH;

   public static void main(String[] argv)
   throws Exception
   {
      System.out.println(VERSION_STRING);
   }
}