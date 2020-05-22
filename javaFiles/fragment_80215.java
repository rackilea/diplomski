@RunWith(MockitoJUnitRunner.class)
public class JsonConfigurationTest {

    @Mock
    Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    @Mock
    ObjectMapper objectMapper;

    @Test
    public void testObjectMapper() {

        JsonConfiguration jsonConfiguration =  new JsonConfiguration();
        doAnswer(invocation -> objectMapper).when(jackson2ObjectMapperBuilder).build();
        ArgumentCaptor<Module> moduleArgumentCaptor = ArgumentCaptor.forClass(Module.class);

        doAnswer(invocation -> {
            Module value = moduleArgumentCaptor.getValue();
            assertTrue(value instanceof JavaTimeModule);
            return objectMapper;
        }).when(objectMapper).registerModule(moduleArgumentCaptor.capture());

        jsonConfiguration.objectMapper(jackson2ObjectMapperBuilder);
        verify(objectMapper, times(1)).registerModule(any(Module.class));
    }
}