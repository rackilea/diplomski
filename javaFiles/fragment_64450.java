public class MapReduceDictionary extends ConcurrentHashMap<String, ArrayList<Integer>>{

    private static final long serialVersionUID = 1L;

    public void addValue(String key, int value) throws InterruptedException {
        ArrayList<Integer> absentArr = new ArrayList<Integer>();
        absentArr.add(value);
        if (putIfAbsent(key, absentArr) == null) return;

        synchronized (get(key)) {
            get(key).add(value);
        }

    }
}