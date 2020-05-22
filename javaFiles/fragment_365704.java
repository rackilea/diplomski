@Override
protected double computePrefWidth(double height) {
    double size = 0;
    for (Node child : getManagedChildren()) {
        double pW = child.prefWidth(height);
        if (pW > size) {
            size = pW;
        }
    }

    // TODO: consider insets ect...
    return size;
}