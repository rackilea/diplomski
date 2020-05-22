Arrays.sort(resultSet.toArray(), new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) { 
            // cast your objects to the correct type (watch out for ClassCastException!), 
            // then compare their month fields
            // and return -1, 0 or 1 according to the contract of Comparator
            return 0;
        }
    });