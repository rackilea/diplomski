@RequestScoped
public class YourBean{

    @Inject
    private MyFacade facade;

    //bean created with builder
    private MyBean bean;

    public String someMethodExecutedwithEL(){
        //build your object here and save it with the dao layer
        facade.save(objectFromBuilder);
    }
    @PostConstruct
    public void init(){
        //create your bean with builder pattern
    }
}