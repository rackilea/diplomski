@RunWith(MockitoJUnitRunner.class)
public class ResourceManagerTest
{
    @Mock
    private JerseyClient jerseyClient;

    @InjectMocks
    private ResourceManager resourceManager;

    @Test
    public void testResultHandling() throws JsonGenerationException, JsonMappingException, IOException, ResourceException
    {
        TestEntity testEntity = new TestEntity();

        testEntity.setGet(true);
        testEntity.setTestAttribute("1stTest");

        when(jerseyClient.get(anyString())).thenReturn("{\"get\":true,\"testAttribute\":\"2ndTest\",\"message\":\"success\"}");   

        TestEntity result = (TestEntity)resourceManager.execute(testEntity, TestEntity.class);

        assertThat(result, is(notNullValue()));
        assertThat(result.getMessage(), is("success"));
        assertThat(result.getTestAttribute(), is("2ndTest"));
    }
}