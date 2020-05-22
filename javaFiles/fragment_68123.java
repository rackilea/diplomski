public abstract class SimpleTask {

    public abstract Duration getDuration();

    public abstract ReadOnlyObjectProperty<Duration> durationProperty();
}

public class Task extends SimpleTask {

    private final ReadOnlyObjectWrapper<Duration> duration = new ReadOnlyObjectWrapper<>();

    @Override
    public Duration getDuration() {
        return duration.get();
    }

    public ReadOnlyObjectProperty<Duration> durationProperty() {
        return duration.getReadOnlyProperty();
    }

    public void start() {
        //update duration value every second using this.duration.set(newDuration);
    }

}

public class Project extends SimpleTask {

    private final ObservableList<Task> tasks;

    private final ReadOnlyObjectWrapper<Duration> duration;

    public Project() {
        this.duration = new ReadOnlyObjectWrapper<>();
        this.tasks = FXCollections.observableArrayList(t -> new Observable[]{t.durationProperty()});
        this.duration.bind(Bindings.createObjectBinding(()
                -> tasks.stream()
                .map(Task::getDuration)
                .reduce(Duration.ZERO, Duration::plus),
                this.tasks));
    }

    @Override
    public Duration getDuration() {
        return duration.get();
    }

    public ReadOnlyObjectProperty<Duration> durationProperty() {
        return duration.getReadOnlyProperty();
    }

}