ExecutorService executorService = Executors.newFixedThreadPool(10);

try
{
  for (String userName : users)
  {
    File userFile = ...

    if (userFile.exists())
    {
      System.out.println("Reading Information " + userName);

      executorService.execute(
        new Runnable()
        {
          public void run()
          {        
            BACControlS.main(args);
          }
        }
      );

      executorService.execute(
        new Runnable()
        {
          public void run()
          {        
            BACControlT.main(args);
          }
        }
      );
    }
    else
    {
      System.out.println("Not Information " + userName);
    }
  }
}
finally
{
  executorService.shutdown();
}