public class DaoFactory
{
   public void create(Object obj)throws Exception
   {
     Session session = HibernateUtil.getSessionFactory().getCurrentSession();
     session.beginTransaction();
     session.save(obj);
     session.getTransaction().commit();
   }
}