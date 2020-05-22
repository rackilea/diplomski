public class ServeChild1Controller extendds AbstractController{

    @Autowired
    public ServeChild1Controller(@Qualifier("child1service") ParentService child1service){
        super(child1service)
    }

}