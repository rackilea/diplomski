class MapAndIndex {
    Map<Integer,List<Integer>> map=new HashMap<>();
    int index;

    void add(int value) {
        map.computeIfAbsent(value, x->new ArrayList<>()).add(index++);
    }
    void merge(MapAndIndex other) {
        other.map.forEach((value,list) -> {
            List<Integer> l=map.computeIfAbsent(value, x->new ArrayList<>());
            for(int i: list) l.add(i+index);
        } );
        index+=other.index;
    }
}