@Stateless
@LocalBean
public class MyBean extends MySuperBean
{
  @EJB
  com.example.project.MyOtherBean otherBean;

  public boolean myService(String userName, MyEntity entity)
  {
     if(otherBean.checkAuthority(userName))
     { 
        super.insert(entity);
     }
   }
 }