public void increment(int row, int column, double num) {
    Position p = new Position(row, column);
    Double current = matrix.putIfAbsent(p, num);

    if (current != null) {
        // there was already a value at the designated position
        double newval = current + num;

        while (!matrix.replace(p, current, newval)) {
            // Failed to replace -- indicates that the value at the designated
            // position is no longer the one we most recently read
            current = matrix.get(p);
            newval = current + num;
        }
    } // else successfully set the first value for this position
}