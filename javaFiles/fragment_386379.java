private <T extends QuadTree<?>> void drawQuadtreeBoxes_helper(T node) {
    if (node == null)
        return;

    Vector3 min = node.bbox.min;
    Vector3 max = node.bbox.max;
    // Draw the boxes (...)

    if (node.hasChildren()) {
        Array<T> children = node.getChildren(); // ERROR HERE
        for (T child : children) {
            drawQuadtreeBoxes_helper(child);
        }
    }
}