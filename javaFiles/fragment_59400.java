codeMed.setComparator(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1 != null ? o1 : Integer.MAX_VALUE) - (o2 != null ? o2 : Integer.MAX_VALUE);
        }
    });