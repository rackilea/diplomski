@RunWith(MockitoJUnitRunner.class)
public class VerifyTest {

    @Rule
    public VerifyNoMoreInteractionsRule noMoreInteractionsRule = new VerifyNoMoreInteractionsRule();

    @Mock
    private YourMock yourMock;

    @Mock
    private AnotherMock anotherMock;

    @Before
    public void setUp(){
        // Register the mocks you want to verify after each test
        noMoreInteractionsRule.add(yourMock);
        noMoreInteractionsRule.add(anotherMock);
    }

    @Test
    public void test(){
        // Put your ordinary test code here
    }

}