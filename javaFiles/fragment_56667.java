@Root(name = "Tournament")
public class Tournament
{
    @Text
    private String data;

    public Tournament(String data)
    {
        this.data = data;
    }

    private Tournament() { /* Required */ }

    // ...
}