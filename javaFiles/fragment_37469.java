@Component
public class ContextClosedHandler implements ApplicationListener<ContextClosedEvent> {
    @Autowired ThreadPoolTaskExecutor executor;
    @Autowired ThreadPoolTaskScheduler scheduler;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        scheduler.shutdown();
        executor.shutdown();
    }       
}