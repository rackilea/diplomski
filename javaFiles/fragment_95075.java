public class TwoRowModel extends DataModel {

    private List<Pair> values = initData();
    private int index = -1;

    private List<Pair> initData() {
        List<Pair> list = new ArrayList<Pair>();
        for (int i = 0; i < 5; i++) {
            Pair pair = new Pair();
            pair.key = "Key " + i;
            pair.value = "Value " + i;
            list.add(pair);
        }
        return list;
    }

    @Override
    public int getRowCount() {
        return values.size() * 2;
    }

    @Override
    public Object getRowData() {
        Pair pair = values.get(index / 2);
        if (index % 2 == 0) {
            return pair.key;
        } else {
            return pair.value;
        }
    }

    @Override
    public int getRowIndex() {
        return index;
    }

    @Override
    public Object getWrappedData() {
        throw new UnsupportedOperationException("Demo code");
    }

    @Override
    public boolean isRowAvailable() {
        int realIndex = index / 2;
        if (realIndex < 0) {
            return false;
        }
        if (realIndex >= values.size()) {
            return false;
        }
        return true;
    }

    @Override
    public void setRowIndex(int idx) {
        this.index = idx;
    }

    @Override
    public void setWrappedData(Object value) {
        throw new UnsupportedOperationException("Demo code");
    }

    class Pair {
        public String key;
        public String value;
    }

}