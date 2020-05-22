public class UserControllerTest extends BaseITCase {

    private Foo foo = Mockito.mock(Foo.class);

    @Autowired
    private UserController userController;

    @Before
    public void setUp() {
        super.setup();

        this.userController.setFoo(foo);
    }
}

@Component
public class UserController {

    private Foo foo;

    @Autowired
    public void setFoo(final Foo foo) {
        this.foo = foo;
    }
}