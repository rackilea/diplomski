public class MapOfListsAdapter extends XmlAdapter<ListWrapper, Map<Integer, List<Condition>>> {

    @Override
    public ListWrapper marshal(Map<Integer, List<Condition>> v) {...}

    @Override
    public Map<Integer, List<Condition>> unmarshal(ListWrapper v) {...}
}