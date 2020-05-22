public class Storage {
    protected static final Map<String, Long> MAP = new ConcurrentHashMap<>();

    public void decrement(String id) {
        MAP.computeIfPresent(id, (id, currentValue) -> --currentValue);
    }

    public void putIntoActiveAgents(String id, Integer num) {
        MAP.put(id, num);
    }

    public void remove(String id) {
        MAP.remove(id);
    }

    public Long get(String id) {
        return MAP.get(ID);
    }
}