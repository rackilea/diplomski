// Returns true if this Rectangle is adjacent to otherRectangle.
public boolean isAdjacentTo(Rectangle otherRectangle, double tolerance) {
    if(Math.abs(getLeftSide()-otherRectangle.getRightSide())<tolerance||Math.abs(otherRectangle.getLeftSide()-getRightSide())<tolerance)
    {
        return !(getTopSide()<otherRectangle.getBottomSide()||otherRectangle.getTopSide()<getBottomSide());
    }
    if(Math.abs(getTopSide()-otherRectangle.getBottomSide())<tolerance||Math.abs(otherRectangle.getTopSide()-getBottomSide())<tolerance)
    {
        return !(getRightSide()<otherRectangle.getLeftSide()||otherRectangle.getRightSide()<getLeftSide());
    }
    return false;
}