private static boolean allTrue (boolean[] values) {
    for (boolean value : values) {
        if (!value)
            return false;
    }
    return true;
}