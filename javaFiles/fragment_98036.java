public class SubList {
    public int size;
    public List<Integer> subList;

    public SubList() {
        this(0, new ArrayList<>());
    }

    public SubList(int size, List<Integer> subList) {
        this.size = size;
        this.subList = subList;
    }
}