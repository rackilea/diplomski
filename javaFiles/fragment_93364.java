public static boolean hasBlankVariables(Object obj) throws IllegalArgumentException, IllegalAccessException {
    for (Field field : obj.getClass().getDeclaredFields()) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        // Danger!
        String str = (String) field.get(obj);
        if (StringUtils.isBlank(str)) {
            return true;
        }
    }
    return false;
}