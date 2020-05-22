public static String getFieldThroughGetterAsStringTransform(Object target, String property) {
    try {
        Method method = target.getClass().getMethod("get" + StringUtils.capitalize(property));
        Object getResult = method.invoke(target);
        return getResult != null ? getResult.toString() : null;
    } catch(Exception e) {
        Log.e(TAG, "Failed to map property [" + property + "] on object [" + target + "]");
        throw new RuntimeException(e);
    }
}