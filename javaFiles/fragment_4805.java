@Aspect
public class MyAspect
{
    private static int counter = 0;

    @Before("execution(* get*())")
    public void incrementCounterProxy()
    {
        counter++;
    }
}