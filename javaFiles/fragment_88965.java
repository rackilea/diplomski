Comparator<Integer> result = new Comparator<Integer>() {
        @Override
        public int compare(Integer n1, Integer n2){
            return n1.compareTo(n2);
        }
    };

PriorityQueue<Integer> heap = new PriorityQueue<Integer>(result);