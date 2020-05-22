public static <T> void print(List<? extends T> list) {
    for (final T t : list) {
        if (t instanceof List) print((List) t);
        else System.out.println(t);
    }
}