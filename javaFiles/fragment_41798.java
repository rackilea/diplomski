for(Future<String> fut : list)
{
  try 
  {               
    System.out.println(new Date() + "::" + fut.get());
  } 
  catch (InterruptedException | ExecutionException e) 
  {
    e.printStackTrace();
  }
}