@Aspect
@Order(1)
public class AspectA
{
  @Before("............")
   public void doit() {}
}

@Aspect
@Order(2)
public class AspectB
{
  @Before(".............")
  public void doit() {}
}