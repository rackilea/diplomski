int a = -1;
while(true)
{
  try
  {
      Scanner in = new Scanner(System.in);
      a = in.nextInt();
  }
  catch(InputMismatchException e)
  {
      e.printStackTrace();   
  }

  //Your switch statement 
 }