public void doStuff()
{
   try
   {

     // some exception can occur here

   } catch (MyException ex){

     // do something specific

     cleanupAfterException(ex);

   } catch (Exception ex) {

     cleanupAfterException(ex);
   }
}

private void cleanupAfterException(Exception ex)
{
   //Do your thing!
}