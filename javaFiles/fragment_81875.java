public String getStatus(final Collection<String> in) {
    final Set<String> set = new HashSet<>(in);
    if (set.contains("Not Available")) {
        return "Not Available";
    }
    if (set.contains("Partial")) {
        return "Partial";
    }
    return "Available";
}