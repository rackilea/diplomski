public class LongArrayList {

    private List<Long> list;

    public LongArrayList() {

    }

    public LongArrayList(List<Long> list) {
        this.setList(list);
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }
}