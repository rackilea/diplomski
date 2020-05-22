try
{
  //Your code to read the document
} 
catch (Throwable t)
{
  t.printStackTrace(); //Check your output
  //Set your breakpoint HERE
  throw new RuntimeException(t.getMessage(), t); //Check the ExceptionHandler for the application.
}