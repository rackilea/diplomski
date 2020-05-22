Comparator<Job> cmp = new Comparator<Job>() {
    @Override
    public int compare(Job j1, Job j2) {
        int p1 = j1.profit;
        int p2 = j2.profit;
        return Integer.compare(j1.getProfit(), j2.getProfit());
    }
};