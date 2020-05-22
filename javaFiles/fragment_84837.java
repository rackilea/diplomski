public static boolean isInList(String var1) {
    for (String s : testList) {
        if (Objects.equals(s, var1)) {
            return true;
        }
    } 
    return false;
}