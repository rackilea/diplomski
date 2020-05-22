int countPointsInRect(Quadtree root, Rectangle r) {

    // Entire bound of current node outside of given rectangle?
    if (root.bounds outside r)
        return 0

    // Part, or whole of current bound inside given rectangle:
    // Recurse on each subtree
    int sum = 0
    for (Quadtree q : sub)
        sum += countPointsInRect(q, r)
    return sum
}