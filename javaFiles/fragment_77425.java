Arrays.sort(array, new Comparator<Project>() {
        @Override
        public int compare(Project o1, Project o2) {
            return o1.id - o2.id; // or whatever property you want to sort
        }
    });