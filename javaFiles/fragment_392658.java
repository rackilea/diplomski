static int compare(String v1, String v2) {
    boolean neg1 = v1.startsWith("-");
    boolean neg2 = v2.startsWith("-");
    return neg1 ? (neg2 ? -comparePositives(v1.substring(1),v2.substring(1)):-1)
                : (neg2 ? 1 : comparePositives(v1, v2));
}

static int comparePositives(String v1, String v2) {
    // Is one longer?
    if (v1.length() != v2.length())
        return v1.length() < v2.length() ? -1 : 1;

    // Both empty?
    if (v1.isEmpty())
        return 0;

    // First digit differs?
    if (v1.charAt(0) != v2.charAt(0))
        return v1.charAt(0) < v2.charAt(0) ? -1 : 1;

    // Recurse on rest of number
    return comparePositives(v1.substring(1), v2.substring(1));
}