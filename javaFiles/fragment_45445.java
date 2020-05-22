private boolean itemsDiffer(String current, String next) {
    if (current == null && next == null {
        return false; // or true, if that's your semantics
    } else {
        return current == null || current.equalsIgnoreCase(next);
    }
}