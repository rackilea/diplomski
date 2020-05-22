public static ErrorStatus getErrorByString(String str) {
    for (Entry<String, ErrorStatus> entry : ERRORS_BY_DESCR.entrySet()){
        if (str.contains(entry.getKey())) {
            return entry.getValue();
        }
    }
    return null;
}