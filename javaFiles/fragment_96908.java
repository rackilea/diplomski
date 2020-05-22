class Ideone {
    public static boolean isPresent(final Throwable t, final Class<?>[] exceptionArray) {
        for (Class<?> exc : exceptionArray) {
            if (exc.equals(t.getClass())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Class<?>[] my = { RuntimeException.class };
        System.out.println("RuntimeException: " + isPresent(new RuntimeException(), my));
        System.out.println("IllegalStateException: " + isPresent(new IllegalStateException(), my));
        System.out.println("NoSuchMethodException: " + isPresent(new NoSuchMethodException(), my));
    }
}