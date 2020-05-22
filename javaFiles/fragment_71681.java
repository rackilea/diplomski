class Sparse<T> {
    Map<Integer, Map<Integer, T>> matrix = new HashMap<>();

    public T get(int row, int col) {
        Map<Integer, T> r = matrix.get(row);
        return r != null ? r.get(col) : null;
    }

    public void set(int row, int col, T t) {
        Map<Integer, T> theRow = matrix.get(row);
        if (theRow == null) {
            theRow = new HashMap<Integer, T>();
            matrix.put(row, theRow);
        }
        theRow.put(col, t);
    }
}

public void test(String[] args) {
    Sparse<Double> s = new Sparse<>();
    s.set(9, 471, 0.9889886);
    s.set(19, 591, 0.98890734);
    s.set(453, 15, 0.98842293);
    s.set(10, 20, 0.98759043);
    s.set(68, 713, 0.9847893);
    s.set(71, 582, 0.9836043);
    s.set(95, 13, 0.98339003);
    s.set(42, 190, 0.9832126);
    s.set(1, 52, 0.9828053);
    s.set(102, 275, 0.981985);
    s.set(110, 1115, 0.9810662);
    s.set(203, 116, 0.98054993);
    s.set(1098, 14, 0.98008114);
    s.set(13, 56, 0.9965508);
    s.set(7, 22, 0.9963229);
    s.set(69, 96, 0.9959787);
    s.set(896, 79, 0.9959084);
}