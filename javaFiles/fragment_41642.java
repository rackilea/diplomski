public static <T extends Comparable<T>> List<T> intersect (List<T> A, List<T> B) {
    List<T> list = new ArrayList<>();       
    int posA = 0;
    int posB = 0;
    while(posA<A.size()&&posB<B.size()) {
        if (A.get(posA).compareTo(B.get(posB))>0) posB++;
        else if (A.get(posA).compareTo(B.get(posB))<0) posA++;
        else if (A.get(posA).equals(B.get(posB))) {
            list.add(A.get(posA));
            posA++; posB++;
        }
    }
    return list;
}