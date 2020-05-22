public class MyService : Service
{
    private Needed dependency;

    public MyService()
    {
        this.dependency = 
            Component.getInstance(Needed.class);
    }
}