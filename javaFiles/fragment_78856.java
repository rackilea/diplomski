public static <T extends Comparable<T>> Collection<T> greater(Collection<T> c, T val) {
    if (c == null || c.size() == 0 || val == null) {
       throw new IllegalArgumentException();
    }

    Collection<T> answer = new ArrayList<T>();
    for (T a : c) {
       if (val.compareTo(a) < 0) {
           answer.add(a);
       }
    }   
    return answer;
}