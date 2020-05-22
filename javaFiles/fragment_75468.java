new Comparator() { // anonymous class body    
        public int compare(emp e1, emp e2) {
            if (e1.getId > e2.getId) {
                return 1;
            }
            if (e1.getId < e2.getId) {
                return -1;
            } else
                return 0;
        }
    }