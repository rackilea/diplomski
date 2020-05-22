@Configuration
public class TestConfiguration {
    @Bean
    RemoteService remoteService() {
        RemoteService remoteService=mock(RemoteService.class);
        when(remoteService.getAll()).thenReturn(new ArrayList<>());
        return remoteService;
    }
}