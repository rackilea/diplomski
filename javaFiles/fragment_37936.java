Collections.sort(list, new Comparator<Job>() {

        @Override
        public int compare(final Job o1, final Job o2) {

            return o1.getPriority()-o2.getPriority();
        }
    });