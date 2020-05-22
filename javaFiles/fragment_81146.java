public class MapAdapter extends XmlAdapter<List<Protocol>,Map<String,Protocol>>{
    @Override
    public List<Protocol> marshal(Map<String,Protocol> map){
        return new ArrayList<Protocol>(map.values());
    }

    @Override
    public Map<String,Protocol> unmarshal(List<Protocol> lst){
        Map<String,Protocol> map = new HashMap<>();
        for(Protocol p : lst){
            map.put(p.getClass().getSimpleName(),p);
        }
        return map;
    }
}