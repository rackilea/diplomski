public class StudentAddedEvent {
    private long ID;
    private String name;
    ...
}

public interface StudentAddedListener {
    void studentAdded(StudentAddedEvent event);
}