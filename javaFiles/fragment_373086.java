public class LocalEvent {

    private String description;
    private LocalDate date;
    private boolean completed = false;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCompleted(boolean completed) {
        this.completed= completed;
    }

    public LocalEvent(LocalDate date, String description) {
        this.setDate(date);
        this.setDescription(description);
    }

    @Override
    public String toString() {
        String base = "At " + this.getDate() + ": " + this.getDescription();
        return completed ? "[✓] " + base : base;
    }
}