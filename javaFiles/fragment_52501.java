public abstract class AbstractDao<T>{
  private Class<T> clazz;  
  public AbstractDao(Class<T> clazz){
     this.clazz = clazz;
  }


  public List<T> list() {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    List result = session.createQuery("from " + clazz.getName()).list();
    return (List<T>) result;
  }
}