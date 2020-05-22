@Component
@Scope("prototype")
public class HomeControllerTest {

    private RoutesTest rt;

    @Autowired
    public HomeControllerTest(FooTest req, RoutesTest rt)
    {
        this.rt = rt;
        String foo = rt.getUrl("caca");

        System.out.println(foo);
    }

}