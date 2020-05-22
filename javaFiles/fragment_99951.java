public static int TestTryFinallyBlock()  
{
  int returnValue; //A temporary return variable
  try
  {
     int  i = 0;     
     i = 10; 
     returnValue = i; 
     i = 40; 
     return returnValue;    
  }
  catch (RuntimeException e)
  {
       i = 40; //finally section code id copied here too
       throw e;
  }
}