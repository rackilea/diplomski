public abstract class BaseCodeCache<T extends BaseCode> {
    private Map<Integer, T> idMap = new HashMap<>();

    public void add(T baseCode) {
        if (baseCode != null) {
            idMap.put(baseCode.getId(), baseCode);
        }
    }

    public List<T> getList() {
        return new ArrayList<>(idMap.values());
    }
}

public class LocationCache extends BaseCodeCache<Location> {}

public class DepartmentCache extends BaseCodeCache<Department> {}