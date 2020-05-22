import org.ares.cdi.hibernate.sf.MySessionFactory;
import org.ares.cdi.hibernate.interceptors.Transactional;

public class Dao {

  @Inject
  private MySessionFactory sf;

  public void get(int id){
    sf.getCurrentSession().get(clazz,id);
  }

  @Transactional
  public void add(Object entity){
    sf.getCurrentSesion().add(entity);
  }
}