abstract class Command {
    private String name;

    protected Command(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return name;
    }

    public abstract void execute();
}