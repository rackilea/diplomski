@Repository
public class UserDaoImpl implements UserDao {

@Autowired
SessionFactory sessionFactory;
//the problem with query is here
public List<User> getAllUsers() {
    Session session=null;
    try 
    {
    Session session = sessionFactory.openSession();
    return session.createSQLQuery("SELECT * FROM user").list();
    }
    catch(Exception e)
    {
     //Logging
    }
    finally
    {
        if(session !=null && session.isOpen)
        {
          session.close();
          session=null;
        }
    }
}

}