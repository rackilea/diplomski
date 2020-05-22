public class MaxThreeArrayList extends ArrayList<Integer> {
    private final Deque<Integer> deque = new LinkedList<>();

    @Override public boolean add(Integer i) {
        deque.addFirst(i);
        if (deque.size() > 3) { deque.removeLast(); }
        return super.add(i);
    }

    public Integer getMax() {
        Integer max = 0;
        for (Integer i : deque) {
            if (i > max) { max = i; }
        }
        return max;
    }
}