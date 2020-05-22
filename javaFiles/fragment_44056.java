public class Preference
{
    private String userName;

    public Preference(String userName)
    {
        this.userName = userName;
    }

    public void savePreference()
    {
        // Default implementation saves it to the screen. ;-)
       System.out.println(userName);
    }
}

public class Foo
{
    private Preference p;

    public Foo(Preference p)
    {
        this.p = p;
    }
}

public class Bar
{
    private Preference p;

    public Bar(Preference p)
    {
        this.p = p;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Preference p = new Preference("Mike");

        Foo f = new Foo(p);
        Bar b = new Bar(p);
    }
}