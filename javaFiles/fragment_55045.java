public enum MainObjectType  {
    StationEntrance(1),
    StationConcourse_Hall(2),
    StationPlatform(3),
    StationStairs(4),
    // ...
    NPM_MajorIssues(3564);        

    private final int id;
    private MainObjectType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}