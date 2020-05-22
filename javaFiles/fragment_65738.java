public class ScratchPad {

   public static void main( String[] args ) throws Exception {
      System.out.println( new File("build.xml").exists() );
      System.out.println( new File("build.xml").getAbsoluteFile() );
   }

}