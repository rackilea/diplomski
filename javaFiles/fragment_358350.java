@Stateless
@EJB(name = MyEJBInterface.JNDI_NAME, beanInterface = MyEJBInterface.class)
public class MyEJBImplementation implements MyEJBInterface {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}