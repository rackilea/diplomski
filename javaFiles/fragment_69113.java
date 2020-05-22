public class Test {
    private static class Pair {
        private final List<Integer> result;
        private final int index;

        private Pair(List<Integer> result, int index) {
            this.result = result;
            this.index = index;
        }

        public List<Integer> getResult() {
            return result;
        }

        public int getIndex() {
            return index;
        }
    }

    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(1, 2, 3, 4, 5);
        foo(items);
    }

    private static void foo(List<Integer> items) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(Collections.<Integer>emptyList(), 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            System.err.println(pair.getResult());

            if (pair.getResult().size() < items.size()) {
                for (int i=pair.getIndex(); i<items.size(); ++i) {
                    List<Integer> copy = new LinkedList<Integer>(pair.getResult());
                    copy.add(items.get(i));
                    queue.add(new Pair(copy, i + 1));
                }
            }
        }
    }
}