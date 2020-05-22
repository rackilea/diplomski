public class MyService : Service
{
    private Needed dependency;

    public MyService(Needed dependency)
    {
        this.dependency = dependency;
    }
}