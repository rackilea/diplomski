public class MyPojo
{
    private Entities Entities;

    public Entities getEntities ()
    {
        return Entities;
    }

    public void setEntities (Entities Entities)
    {
        this.Entities = Entities;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Entities = "+Entities+"]";
    }
}


public class Entities
{
    private String TotalResults;

    private Entity[] Entity;//you can use List<> insted 

    public String getTotalResults ()
    {
        return TotalResults;
    }

    public void setTotalResults (String TotalResults)
    {
        this.TotalResults = TotalResults;
    }

    public Entity[] getEntity ()
    {
        return Entity;
    }

    public void setEntity (Entity[] Entity)
    {
        this.Entity = Entity;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [TotalResults = "+TotalResults+", Entity = "+Entity+"]";
    }
}