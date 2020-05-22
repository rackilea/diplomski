public interface Role
{
    String getName();
}

public enum StandardRole implements Role
{
    Owner, Administrator, User, Guest;

    @Override
    public String getName()
    {
        return this.name();
    }
}

public class CustomRole implements Role
{
    private String name;

    public CustomRole(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return this.name;
    }
}

public class User
{
    Set<Role> roles;
}