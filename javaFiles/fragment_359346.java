Collections.sort(myList, new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
        }
    });