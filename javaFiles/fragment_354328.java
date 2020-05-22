interface Listener<T> {
    void matched(T t1);
    void onlyIn1(T t1);
    void onlyIn2(T t2);
}

public static <T> void compare(List<T> list1, List<T> list2, Listener<T> tListener) {
    Set<T> onlyIn1 = new HashSet<T>();
    Set<T> onlyIn2 = new HashSet<T>();
    for (int i = 0; i < list1.size(); i++) {
        T t1 = list1.get(i);
        T t2 = list2.get(i);
        if (t1.equals(t2)) {
            tListener.matched(t1);
            continue;
        }
        if (onlyIn2.remove(t1)) 
            tListener.matched(t1);
         else 
            onlyIn1.add(t1);
        if (!onlyIn1.remove(t2))
            onlyIn2.add(t2);
    }
    for (T t1 : onlyIn1)
        tListener.onlyIn1(t1);
    for (T t2 : onlyIn2)
        tListener.onlyIn2(t2);
}