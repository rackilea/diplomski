public class ValueMapListConverter 
    extends StdConverter<Map<Entity2, Integer>, List<Entry<String, Integer>>> {
    @Override
    public List<Entry<String, Integer>> convert(Map<Entity2, Integer> value) {
        List<Entry<String, Integer>> result = new ArrayList<>();
        for (Entry<Entity2, Integer> entry : value.entrySet()) {
            result.add(new SimpleEntry<>(entry.getKey().getId().toString(), 
                       entry.getValue()));
        }
        return result;
    }
}

public class ValueMapMapConverter 
    extends StdConverter<List<Entry<String, Integer>>, Map<Entity2, Integer>> {
    @Override
    public Map<Entity2, Integer> convert(List<Entry<String, Integer>> value) {
        Map<Entity2, Integer> retValue = new HashMap<>();
        for(Entry<String, Integer> entry : value) {
            retValue.put(new Entity2(Long.parseLong(entry.getKey())), entry.getValue());
        }
        return retValue;
    }
}