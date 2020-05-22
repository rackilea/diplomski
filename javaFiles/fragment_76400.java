public class MyClass
{
  private URL url;

  public MyClass(URL url)
  {
    this.url = url;
  }

  public MyClass(String urlString) throws MyPackageSpecificException
  { 
    this(toURL(urlString));
  }

  private static URL toURL(String urlString) throws MyPackageSpecificException
  {
    try
    {
      return new URL(urlString));
    } 
    catch (MalformedURLException e)
    {
        throw new MyPackageSpecificException(e);
    }
  }
}