@Component
public class AppContext {    

    private final MyElasticsearchRepository repository;

    @Autowired
    public AppContext(MyElasticsearchRepository repository){
        this.repository=repository;
    }
    ...
}