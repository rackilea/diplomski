public class MasteryPage {
    private long id;
    private String name;
    private boolean current;
    private Map<Long,Integer> masteries = new HashMap<>();

    public MasteryPage(long id, String name, boolean current) {
        this.id = id;
        this.name = name;
        this.current = current;
    }

    public void addMastery(long id, int rank) {
        masteries.put(id, rank);
    }

    // add getters/setters...      
}