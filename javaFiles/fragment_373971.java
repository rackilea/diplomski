@RunWith(PowerMockRunner.class)
@PrepareForTest({MongoConnection.class})
public class ATest {

    @Test
    public void aTestWhichRequiresMockingMongoConnection() {
        MongoClient mongoClient = Mockito.mock(MongoClient.class);
        PowerMockito.mockStatic(MongoConnection.class);

        Mockito.when(MongoConnection.getClient()).thenReturn(mongoClient);

        // set up some expectations on the mocked MongoClient returned by MongoConnection    
        Mockito.when(mongoClient.getDatabase("aDatabaseName")).thenReturn(...);

        // ... etc
    }
}