class Test<E extends Comparable<E>> {
    List<E> list;

    Test(Set<E> arbSet) {
        this.list = new ArrayList<>(arbSet);
        Collections.sort(this.list);
        System.out.println(this.list);
    }
}