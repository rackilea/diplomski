public class MultiMap {
    private Map<String, List<Double>> multi = new HashMap<>();

    public void put(String key, Double newValue) {
        if (newValue != null) {
            List<Double> values = (this.multi.containsKey(key) ? this.multi.get(key) : new ArrayList<>());
            values.add(newValue);
            this.multi.put(key, values);
        }
    }
}