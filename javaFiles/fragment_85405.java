public static boolean isCause(
    Class<? extends Throwable> expected,
    Throwable exc
) {
   return expected.isInstance(exc) || (
       exc != null && isCause(expected, exc.getCause())
   );
}