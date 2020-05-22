import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TrackMap<K, V>  extends HashMap<K,V>{
    private static final long serialVersionUID = 1L;

    Set<Object> usedKeys = new HashSet<>();

    @Override
    public V get(Object key) {
        usedKeys.add(key);
        return super.get(key);
    }

    public Set<Object> getUsedKeys() {
        return usedKeys;
    }

    public static void main(String[] args) {
        TrackMap<Integer, String> test = new TrackMap<>();
        for(int i = 0;i<100;++i) {
            test.put(i, Integer.toString(i));
        }
        System.out.println(test.get(5));
        System.out.println(test.get(10));
        System.out.println(test.get(15));
        System.out.println(test.get(17));
        System.out.println(test.get("what?"));

        for(Object i : test.getUsedKeys()) {
            System.out.println("The key " + i + " was accessed");
        }
    }
}