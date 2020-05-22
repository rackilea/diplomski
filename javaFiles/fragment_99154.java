class ColPriComp implements Comparable<ColPriComp> {
    private volatile int[] priorities; // possibly static, or obtained some other way,
    // so there's only one shared among all classes

    @Override
    public int compareTo(ColPriComp other) {
        // use "priorities" to do the comparison
    }

    public void setPriorities(int[] newPriorities) {
        this.priorities = newPriorities;
    }
}