public class SparseMatrix {
    private Map<String, Object> map;
    private Object default;

    public SparseMatrix(Object default) {
        this.default = default;
        map = new HashMap<String, Object>();
    }

    public Object get(int x, int y) {
        String key = x + "." + y;
        String value = map.get(key);
        if (value == null) {
            return default;
        }
        return value;
    }

    public void set(int x, int y, Object value) {
        String key = x + "." + y;
        if (value.equals(default)) {
           map.remove(key);
        } else {
           map.put(key, value);
        }
    }
}