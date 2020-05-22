public interface URLProvider
{
  String getBase();
}


public final class BaseImplementation
{
  public BaseImplementation(URLProvider provider)
  {
    if (null == provider)
      throw new NullPointerException();
    this.provider = provider;
  }


  public String getResource1()
  {
    return processTemplate1(provider.getBase());
  }


  public String getResource2()
  {
    return processTemplate2(provider.getBase());
  }


  private final URLProvider provider;
}