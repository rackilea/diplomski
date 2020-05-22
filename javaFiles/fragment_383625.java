TreeSet<TreeSet<Integer>> outer = new TreeSet<TreeSet<Integer>>(
    new Comparator<TreeSet<Integer>>() {
        public int compare(TreeSet<Integer> lhs, TreeSet<Integer> rhs) {
            Iterator<Integer> li = lhs.Iterator();
            Iterator<Integer> ri = rhs.Iterator();
            while (li.hasNext() && ri.hasNext()) {
                int res = li.next().compareTo(ri.next());
                if (res != 0) return res;
            }
            if (li.hasNext()) return 1;
            if (ri.hasNext()) return -1;
            return 0;
        }
    }
);