public class Main
{
   public static void main( final String[] args )
   {

      final Thread t1 = new Thread()
      {
         @Override
         public void run()
         {
            try
            {
               while ( true )
               {
                  Thread.sleep( 1000 );
               }

            }
            catch ( final InterruptedException e )
            {
               System.out.println( "This thread was interrupted!" );
            }
         }
      };
      t1.start();
      t1.interrupt();
   }
}