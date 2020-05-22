@Component
class ScheduledJob {

    private final AtomicBoolean enabled = new AtomicBoolean(false);

    @Scheduled(fixedRate = 1000)
    void execute() {
        if (enabled.get()) {
            // run spring batch here.
        }
    }

    void toggle() {
        enabled.set(!enabled.get());
    }

}