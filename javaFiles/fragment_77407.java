finally
{
   try
   {
      session.close();
   }
   catch (Exception ex)
   {
      System.err.println("session.close() : " + ex.getLocalizedMessage());
   }

   try
   {
      connection.close();
   }
   catch (Exception ex)
   {
      System.err.println("connection.close() : " + ex.getLocalizedMessage());
   }
}