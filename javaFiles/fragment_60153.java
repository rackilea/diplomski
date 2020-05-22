/**
 * Finds the bounding Rectangle of a word located at a Point.
 * 
 * @param p Point to find word bounds
 * @param wordBounds List of word boundaries to search
 * @return A Rectangle that bounds a word and contains a point, or null if 
 *         there is no word located at the point
 */
private Rectangle findWordBoundsAtPoint(Point p, List<Rectangle> wordBounds) {
    Rectangle result = null;
    for (Rectangle wordBound : wordBounds) {
        if (wordBound.contains(p)) {
            result = wordBound;
            break;
        }
    }
    return result;
}