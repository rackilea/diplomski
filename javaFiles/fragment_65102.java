public class MyAction extends ActionSupport {

    private IMyService myService;

    @Autowired
    public MyAction(MyService myService) {
        this.myService = myService;
    }

    public String execute(){
        getText("SomeText");
        myService.something();
        return SUCCESS;
    }
}

@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {

    @Mock
    private IMyService myService;

    private MyAction myAction;

    @Before
    public void setup() {
        myAction = spy(new MyAction(myService));
    }

    @Test
    public void test() {

        assertThat(myAction.execute(), equalTo(Action.SUCCESS));

        verify(myAction, times(1)).getText();

        verify(myService, times(1)).something();
    }
}