try
{
   // open a file (Compiler will force to either catch or throw)
}
catch (IOException ioe)
{
   ioe.printStackTrace();

   // need to make a decision on what to do here
   // log it, wrap it in a RuntimeException, etc.
}