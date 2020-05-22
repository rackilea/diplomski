public class MapAdapter extends XmlAdapter<MapAdapter.AdaptedMap, Map<String, LabelledElement>> {

    public static class AdaptedMap {

        @XmlVariableNode("key")
        List<LabbeledElement> entries = new ArrayList<LabbeledElement>();

    }

    public static class AdaptedEntry {

        @XmlTransient
        public String key;

        @XmlElement
        public LabelledElement value;

    }

    @Override
    public AdaptedMap marshal(Map<String, LabelledElement> map) throws Exception {
        AdaptedMap adaptedMap = new AdaptedMap();
        for(Entry<String, LabelledElement> entry : map.entrySet()) {
            AdaptedEntry adaptedEntry = new AdaptedEntry();
            adaptedEntry.key = entry.getKey();
            adaptedEntry.value = entry.getValue();
            adaptedMap.entries.add(adaptedEntry);
        }
        return adaptedMap;
    }

    @Override
    public Map<String, LabelledElement> unmarshal(AdaptedMap adaptedMap) throws Exception {
        List<AdaptedEntry> adaptedEntries = adaptedMap.entries;
        Map<String, LabelledElement> map = new HashMap<String, LabelledElement>();
        for(AdaptedEntry adaptedEntry : adaptedEntries) {
            map.put(adaptedEntry.key, adaptedEntry.value);
        }
        return map;
    }

}