public class RetryWsCall
{ 
  public interface RetryCallInterface
  {
    public <T> T RetryCallMethod();
  };

  public <T> T callWs(RetryCallInterface retryCallImplementation, int retryCount) 
  {
    try
    {
      return retryCallImplementation.RetryCallMethod();
    }
    catch (Exception ex)
    {
      if (retryCount > 0)
      {
        while (retryCount > 0)
        {
          try
          {
            return result = retryCallImplementation.RetryCallMethod();
          }
          catch (Exception ex0)
          {
            retryCount--;
          } 
        }
      }
      throw ex;
    }
  }
}