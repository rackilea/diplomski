public class Task {

    private Priority priority = Priority.ZERO; // Default priority
    private String name = "";

    public enum Priority {
        ZERO, MAYBE, LOW, MEDIUM, HIGH, EXTREME;
    }

    public Task(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
       return name;
    }

    public void setPriority(Priority p) {
        this.priority = p;
    }

    public Priority getPriority() {
        return priority
    }

    public static void main(String[] args) {
        Task t = new Task("Washing up");
        t.setPriority(Priority.HIGH);
        System.out.println(t.getName()); // Washing up
        System.out.println(t.getPriority().toString()); // This gets the string of HIGH
        System.out.println(t.getPriority().ordinal()); // this gives 4
    }
}