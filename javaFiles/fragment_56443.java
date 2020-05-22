class Test
{
  ...
  @Override
  public int hashCode()
  {
     return 31*firstname.hashCode() + secondname.hashCode();
  }

  @Override
  public boolean equals(Object obj)
  {
     // basic type validation
     if (!(obj instanceof Test))
        return false;

     Test t = (Test)obj;
     return firstname.equals(t.firstname) && secondname.equals(t.secondname);
  }
}