public class YourDaoClassTest{
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private JdbcTemplate jdbcTemplate;
    @Mock
    private ItemPreparedStatementCreatorFactory preparedStatementCreatorFactory;
    @Mock
    private PreparedStatementCreator preparedStatementCreator;

    YourDaoClass yourDaoClass;


    @Before
    public void setup(){
      // I prefer direct object creation over @InjectMocks since the latter does not raise compile errors on missing constructor arguments...
      yourDaoClass = new YourDaoClass(preparedStatementCreatorFactory,jdbcTemplate); 
    }  


    @Test
    public void passesItemToStatementFactory(){
       Item item = new Item();
       doReturn(preparedStatementCreator)
            .when(preparedStatementCreatorFactory)
            .createFor(item);

       yourDaoClass-update(item);

       InOrder inOrder= inOrder(preparedStatementCreatorFactory,jdbcTemplate);
       inOrder.verify(preparedStatementCreatorFactory).createFor(item);
       inOrder.verify(jdbcTemplate).update(preparedStatementCreator);
    }
}