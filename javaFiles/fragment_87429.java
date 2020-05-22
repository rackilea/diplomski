private void packageTest(Object a) {
try {
    Method method = a.getClass().getDeclaredMethod("print");
    method.invoke(a);
} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
    e.printStackTrace();
}