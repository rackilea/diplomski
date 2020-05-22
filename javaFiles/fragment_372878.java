public boolean matches(Set<String> set, String line) {
    for (String check: set) {
        if (line.contains(check)) return true;
    }
    return false;
}