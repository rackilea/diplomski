@ManagedBean(name="beanA") @RequestScoped
public class BeanA implements Serializable {
  @ManagedProperty(value="#{beanB}") 
  private BeanB beanB;
  public void setBeanB(BeanB b) { this.beanB = b; }
  public BeanB getBeanB() { return beanB; }
}

@ManagedBean(name="beanB") @RequestScoped
public class BeanB implements Serializable {}