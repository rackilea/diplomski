public class CustomMap extends HashMap<String, ArrayList<Double>> {
    @Override
    public ArrayList<Double> put(String key, ArrayList<Double> value) {
        for (Entry<String, ArrayList<Double>> entry : entrySet()) {
            if (entry.getValue().equals(value)) {
                String oldKey = entry.getKey();
                remove(oldKey);
                String newKey = oldKey + ", " + key;
                return super.put(newKey, value);
            }
        }
        return super.put(key, value);
    }
}