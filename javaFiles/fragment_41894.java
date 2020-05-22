import java.util.concurrent.ExecutorService;
import org.kie.internal.concurrent.ExecutorProviderFactory;
...

@Startup
@Singleton
public class PlausiServiceLifecycleManager {

    /**
     * Shuts down Drools' internal ExecutorService, so that its threads can terminate.
     */
    @PreDestroy
    public void shutdown() {
        ExecutorService executor = (ExecutorService) ExecutorProviderFactory.getExecutorProvider().getExecutor();
        executor.shutdown();
    }


}