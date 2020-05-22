@Repository(value="aDaoImpl")
@Transactional
public class ADaoImpl {

    @Override
    public A loadByPrimaryKey(long id)
    {   
        Session session = sessionFactory.getCurrentSession();
        session.enableFetchProfile("a-with-b");
        session.enableFetchProfile("b-with-c");
        Criteria criteria = session.createCriteria(A.class);
        criteria.add(Restrictions.eq("id", id));
        A a = (A) criteria.uniqueResult();
        if(identity != null)
            return identity;
        else
            return null;
    }
}