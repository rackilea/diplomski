void exchange(int i, int j) {
    ListIterator<int[]> it1 = matrix.listIterator(i),
                        it2 = matrix.listIterator(j);
    int[] temp = it1.next();
    it1.set(it2.next());
    it2.set(temp);
}