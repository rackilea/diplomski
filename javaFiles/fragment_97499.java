public interface Person
{
    String getName();
}

public class MutablePerson implements Person
{
    private String name;

    public MutablePerson(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}