private int depth(
    Position<Integer> p
) throws InvalidPositionException, BoundaryViolationException 
{
    return ab.isRoot(p) ? 0 : 1 + depth(ab.parent(p));
}