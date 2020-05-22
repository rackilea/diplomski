public class ItemPreparedStatementCreatorFactoryTest{
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private Connection connection;

    @Before
    public void setup(){
      // maybe exchange anyString() with an ArgumentCaptor
       doReturn(preparedStatement).when(connection).prepareStatement(anyString());
    }

    @Test
    public void passesNameAndIdToPreparedStatement(){
       Item item = new Item();
       item.setName("an valid name");
       item.setID(ANY_VALID_ID);

       ItemPreparedStatementCreatorFactory itemPreparedStatementCreatorFactory =
           new ItemPreparedStatementCreatorFactory();
       PreparedStatement createdPreparedStatement = itemPreparedStatementCreatorFactory.createFor(item);

       verify(createdPreparedStatement).setString(1, item.getName());
       verify(createdPreparedStatement).setInt(1, item.getId());
   }
}