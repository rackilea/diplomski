/**
 * @return The scale factor from milliseconds to visual units 
 */
public double getScale(){
    final double length = getSide().isHorizontal() ? getWidth() : getHeight();

    // Get the difference between the max and min date.
    double diff = currentUpperBound.get() - currentLowerBound.get();

    // Get the actual range of the visible area.
    // The minimal date should start at the zero position, that's why we subtract it.
    double range = length - getZeroPosition();

    return length/diff;
}