public String getTrimmedString(String str) {
    if (str.trim().isEmpty()) {
        return null;
    } else {
        return str.trim();
    }
}