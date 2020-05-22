public interface TaskType {
    public abstract void handleTask(AService service, ScheduledEvent scheduledEvent);
}

@Component
public class CreateMaterial implements TaskType {

    @Autowired
    private static AService service;

    @Override
    public void handleTask(ScheduledEvent scheduledEvent) {
        service.createMaterial(scheduledEvent);
    }
};