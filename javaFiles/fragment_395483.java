public class Spiral7DGenerator implements Iterator<List<Integer>> {
    private BlockingQueue<List<Integer>> spirals = new SynchronousQueue<List<Integer>>();

    @Override
    public List<Integer> next() {
        return spirals.take();
    }

    private void generate(int pos, Integer... array) {
        if (pos == array.length) {
            List<Integer> list = new ArrayList<>();
            list.addAll(Arrays.asList(array));
            spirals.put(list);
            return;
        }
    // etc
    }
}