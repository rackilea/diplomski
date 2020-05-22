class Business
{
    DataAccess dataAccess;
    //.....

    public void removeEntity(Entity e)
    {
        //do pre removal here
        dataAccess.remove(e);
    }
    //......
}

class DataAccess
{
    EntityManager em;

    //......

    public void remove(Entity e)
    {
        em.remove(e);
    }

    //....
}