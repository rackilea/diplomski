static class Inner {
    static {
        Integer.parseInt(null);
    }
}

public static void main(String... args) {
    try {
        new Inner();
    } catch (Throwable e) {
        e.printStackTrace();
    }
    new Inner();
}