@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class CreateMailboxServiceMockTest {

    @Mock
    UserInfoService mUserInfoService;

    CreateMailboxService mCreateMailboxService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mCreateMailboxService = new CreateMailboxService();
        mCreateMailboxService.setUserInfoService(mUserInfoService);
    }

    ...
}