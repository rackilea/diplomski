public class Adapter 
extends XmlAdapter<ListOfEntry, Map<String, List<Parameter>>> {
    @Override
    public Map<String, List<Parameter>> unmarshal(ListOfEntry loe)
        throws Exception {
        Map<String, List<Parameter>> map = new HashMap<>();
        for(Entry entry : loe.getList() ) {
            map.put(entry.getKey(), entry.getList() );
        }
        return map;
    }

    @Override
    public ListOfEntry marshal(Map<String, List<Parameter>> map)
        throws Exception {
        ListOfEntry loe = new ListOfEntry();
        for(Map.Entry<String, List<Parameter>> mapEntry : map.entrySet()) {
            Entry entry = new Entry();
            entry.setKey( mapEntry.getKey() );
            entry.getList().addAll( mapEntry.getValue() );
            loe.getList().add(entry);
        }
        return loe;
    }
}