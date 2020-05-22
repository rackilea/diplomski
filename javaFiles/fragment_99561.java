public class Distribution {
    private ArrayList<LinkedList<Integer>> group = new ArrayList<>();    

    public Distribution() {
        group.add(new LinkedList<>());
        group.get(0).add(1);
        ...
        group.add(new LinkedList<>());
        group.get(1).add(4);
        ...
    }
    ... 
}