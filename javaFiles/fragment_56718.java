private Object callMethod(CodeHandler codeHandler, String methodName, String message) {
    try {
        Method method = DataHandler.class.getDeclaredMethod(methodName, String.class);
        method.setAccessible(true);

        return method.invoke(codeHandler, message);
    } catch (NoSuchMethodException e) {
        handle(e);
    } catch (IllegalAccessException e) {
        handle(e);
    } catch (InvocationTargetException e) {
        handle(e);
    }
}