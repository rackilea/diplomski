public abstract class Single
{
  abstract Proto newInstance();

  public void useBean()
  {
    System.out.println( newInstance() );
  }

}