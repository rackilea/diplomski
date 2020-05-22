public static boolean isNoneBlank(String... strings) {
    for (String string : strings) {
        if (!StringUtils.isNotBlank(string)) {
            return false;
        }
    }
    return true;
}