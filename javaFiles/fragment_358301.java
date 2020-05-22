public class Leaky
{
  private static List<Object> neverRead = new ArrayList<Object>();
  public static void main(String[] args)
  {
    while(true)
    {
      neverRead.add(new Object());
    }
  }
}