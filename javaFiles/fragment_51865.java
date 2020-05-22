private static EntityManagerFactory em = Persistence
        .createEntityManagerFactory( "mysqldb" );

public static EntityManagerFactory getEmf()
{
    return em;
}