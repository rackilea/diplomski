public static <T> void copy2(List<? super T> dst, List<? extends T> src) {
    // Copy
}

public static void main(String[] args) {
    List<Number> dst = new ArrayList<Number>();
    List<Integer> src = getSource();

    copy2(dst, src);  // Works when 2nd generic param type subclass of 1st
    copy2(dst, dst);  // Works when 2nd generic param type same as 1st
    copy2(src, dst);  // Invalid types for method!
}