public class ComboTest {
    public static class Combo {
        private Integer[] values;

        public Combo(Integer[] values) {
            this.values = values;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + Arrays.hashCode(values);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Combo)) {
                return false;
            }
            Combo other = (Combo) obj;
            if (!Arrays.equals(values, other.values)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return Arrays.toString(values);
        }

    }

    public static Set<Combo> combos(Combo start, int lowerBound) {
        Set<Combo> answers = new HashSet<Combo>();

        compute(start, lowerBound, answers);

        return answers;
    }

    private static void compute(Combo start, int lowerBound, Set<Combo> answers) {
        Deque<Combo> dfsStack = new ArrayDeque<Combo>();

        dfsStack.push(start);

        while (!dfsStack.isEmpty()) {
            Combo current = dfsStack.pop();
            answers.add(current);

            for (Combo next : expand(current, lowerBound)) {
                if (!answers.contains(next)) {
                    dfsStack.push(next);
                }
            }
        }
    }

    private static List<Combo> expand(Combo current, int lowerBound) {
        List<Combo> nexts = new ArrayList<Combo>();

        for (int i = 0; i < current.values.length; i++) {
            if (current.values[i] > lowerBound) {
                Integer[] copyCurrent = Arrays.copyOf(current.values, current.values.length);
                copyCurrent[i]--;
                nexts.add(new Combo(copyCurrent));
            }
        }

        return nexts;
    }

    public static void main(String[] args) {
        Combo start = new Combo(new Integer[] { 4, 3, 2 });
        Set<Combo> combos = combos(start, 1);

        for (Combo combo : combos) {
            System.out.println(combo);
        }

        System.out.println(combos.size());
    }

}