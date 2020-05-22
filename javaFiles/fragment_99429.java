public String run(Circle[] b, int low, int high, int x) {
    if (low > high || ((low == high) && high >= b.length)) {
        return "This Circle is not found.";
    } else {
        int mid = ((high + low) / 2);
        if (key.compareTo(b[mid].radius) == 0)
            return "You wanted to find Circle: " + key + " It is in element: " + mid;
        if (key.compareTo(b[mid].radius) > 0) {
            return run(b, mid + 1, high, x++);
        } else {
            return run(b, low, mid - 1, x++);
        }
    }
}