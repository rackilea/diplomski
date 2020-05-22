// both values are null, so not ascending
    if (left == null && right == null) return false;

    // left is null, but right is not
    if (left == null) return true;

    // right is null, but left is not
    if (right == null) return false;

    return (left.compareToIgnoreCase(right) > 0);