interface Add {
    int sum();
    default Add add(int num) {
        int sum = sum() + num;
        return () -> sum;
    }
    static Add num(int num) {
        return () -> num;
    }
}