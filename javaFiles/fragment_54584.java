private static boolean method1() {
    ...
    Boolean result = method2(someString);
    if (result == null) {
        // the method didn't "work"
        return false;
    }