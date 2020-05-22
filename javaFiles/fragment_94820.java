@ManagedBean
@ViewScoped
public class OrdersMB {
    //attributes, methods, getters, setters...
    @PostConstruct
    public void init() {
        try {
            getOrderLists();
        } catch (NamingException ne) {
            //handle your error here...
        }
    }
}