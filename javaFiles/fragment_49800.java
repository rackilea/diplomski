package x;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named( value = "counterController" )
@RequestScoped
public class counterController
{

  @EJB
  private CounterBean counterBean;

  @PostConstruct
  public void initialize()
  {
    counterBean.incHitCount();  
  }

  public int getHitCount()
  {
    return counterBean.getHitCount();
  }

  public CounterController()
  {
  }

}