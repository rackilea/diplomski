public class UserHelperTest{

    @InjectMocks
    UserHelper userHelper;

    @Mock
    IUSerDetails repo;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFindUserById()
    {
        String id = "id";
        String name = "name";
        String unit = "unit";
        String passwd = ""passwd";

        List<Object[]> queryResult = new ArrayList<>(); 
        queryResult.add(new Object[]{id,name,unit});

        Mockito.when(repo.findUserByID(id,passwd)).thenReturn(queryResult));

        List<UserDetailsDTO> resultList = userHelper.findUserbyID(id,passwd);

        // assertions on size and content of first element..