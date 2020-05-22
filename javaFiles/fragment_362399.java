public class MyMapAdapter extends XmlAdapter<Info, Map<String, String>> {

    private HashMap<String, String> hashMap = new HashMap<String, String>();

    @Override
    public Map<String, String> unmarshal(Info v) throws Exception {
        hashMap.put(v.getKey(), v.getValue());
        return hashMap;
    }

    @Override
    public Info marshal(Map<String, String> v) throws Exception {
        // do here actions for marshalling if u also marshal
        return null;
    }
}