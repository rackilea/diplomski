static class MyObj {
    @NoConnection private static Object obj = new Object();

    public static boolean test() throws NoSuchFieldException, SecurityException {
        return AnnotationDetector.isAnnotated(MyObj.class.getDeclaredField("obj"));
    }
}

private static class AnnotationDetector {
    public static boolean isAnnotated(AnnotatedElement f) {
        return f.isAnnotationPresent(NoConnection.class);
    }
}