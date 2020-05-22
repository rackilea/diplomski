X x = ...
if (BUILD.VERSION.RELEASE.compareTo("2.0") >= 0) {
    // (exception handling omitted ...)
    Method m = c.getClass().getDeclaredMethod("y");
    m.invoke(x);
}