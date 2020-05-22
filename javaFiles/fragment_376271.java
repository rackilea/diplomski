@ManagedBean
@ViewScoped
public class Cars {

    private Long id;
    private Car car;

    @EJB
    private CarService service;

    public void init() {
        car = service.find(id);
    }

    // ...
}