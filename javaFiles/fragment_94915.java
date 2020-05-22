public class EmployeeDAOImpl extends BaseDAOImpl implements EmployeeDAO{

   //this reference should be from base class,
   // the extending class ref is hiding base ref.
  //  private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
      super.setSessionFactory(sf);
    }
}