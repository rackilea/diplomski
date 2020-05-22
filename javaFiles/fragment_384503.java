public static <T> void print(Collection<T> set) {
    if (set == null) {
       System.out.print("null");
       return;
    }
    System.out.print("[ ");
    String sep = "";
    for (T t : set) {
        System.out.print(sep);
        sep = ", ";
        if (t instanceof Collection) {
            print((Collection) t);
        } else {
            System.out.print(t);
        }
    }
    System.out.print(" ]");
}

public static <T> void println(Collection<T> set) {
    print(set);
    System.out.println();
}