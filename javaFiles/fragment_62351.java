public static int callStackOverflow() {
    try {
        return callStackOverflow();
    } catch (Error e) {
        System.out.println(e);
        return 0;
    } finally {
    }
}