public class BeanManager implements BeanFactoryAware {

  private BeanFactory beanFactory;

  public Person getPerson(){ beanFactory.getBean(Person.class) ;}   

}