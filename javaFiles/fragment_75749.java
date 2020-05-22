class Test {
    <E extends Comparable<E>> Test(Set<E> arbSet) {
        List<E> list = new LinkedList<>(arbSet);
        Collections.sort(list);
        System.out.println(list);
    }
}