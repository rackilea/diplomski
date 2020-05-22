public enum Type
{

    MAIN(1, "Main Description"),
    MAIN_UK(2, "Main UK Description"),
    //....
    //Define all the types
    //....
    UNKNOWN(-1, "Unknown Type");

    private int id;
    private String description;

    private Type(int id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public static Type getById(int id)
    {
        for (Type type : Type.values())
        {
            if (id == type.getId())
            {
                return type;
            }
        }

        return Type.UNKNOWN;
    }

    public final int getId()
    {
        return id;
    }

    public final String getDescription()
    {
        return description;
    }
}

public class MyObject
{
    private int id;
    private Type type;

    public MyObject(int id)
    {
        this.id = id;
        this.type = Type.getById(id);
    }

    public int getId()
    {
        return id;
    }

    public Type getType()
    {
        return type;
    }

    public String getDescription()
    {
        return type.getDescription();
    }
}