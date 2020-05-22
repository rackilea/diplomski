public void sortByTime() {
    AbstractList<Job> list = new ArrayList<Job>();
    //add some items
    Collections.sort(list, new Comparator<Job>() {
        public int compare(Job j1, Job j2) {
            return j1.timeElapsed - j2.timeElapsed;
        }
    });
}