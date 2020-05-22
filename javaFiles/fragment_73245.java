public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return 1;
            }
        });
        Deque<Integer> deq = new LinkedList<Integer>();
        deq.add(5);
        deq.add(1);
        deq.add(3);
        set.addAll(deq);
        System.out.println(deq); // 5,1,3
    }