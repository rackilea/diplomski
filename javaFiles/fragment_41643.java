@SuppressWarnings("unchecked")
public static <T extends Comparable<T>, L extends List<T>> L intersect(L A, L B)  {

    if (A.getClass() != B.getClass()) {
        throw new IllegalArgumentException("not same type between ...");
    }
    List<T> list = A.getClass()
                    .newInstance(); // uncheck

    int posA = 0;
    int posB = 0;
    while (posA < A.size() && posB < B.size()) {
        if (A.get(posA)
             .compareTo(B.get(posB)) > 0)
            posB++;
        else if (A.get(posA)
                  .compareTo(B.get(posB)) < 0)
            posA++;
        else if (A.get(posA)
                  .equals(B.get(posB))) {
            list.add(A.get(posA));
            posA++;
            posB++;
        }
    }
    return (L) list; // uncheck
}