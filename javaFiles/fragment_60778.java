@Component
public class Controller{


    WebappRepository repo;

    @Autowire
    public Controller(WebappRepository repo){
        this.repo = repo;
    }
}