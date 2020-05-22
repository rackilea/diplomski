class User {
    private String timeSpent;
    @SerializedName("worklog")
    private List<WorkLog> worklogs = new LinkedList<WorkLog>();
    private String name;

    public List<WorkLog> getWorklogs() {
        return worklogs;
    }

    public void setWorklog(List<WorkLog> worklogs) {
        this.worklogs = worklogs;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}