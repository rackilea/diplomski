public void print(Object o) {
    if (o instanceof String[]) {
        System.out.println(Arrays.toString((String[]) o));
    }
    else if (o instanceof int[]) {
        System.out.println(Arrays.toString((int[]) o));
    }
}