/**
 * Determines whether the specified {@code PositionSequence} is counter-clockwise.
 * <p/>
 * <p>Only the first three positions, are inspected to determine whether the sequence is counter-clockwise.
 * In case are less than three positions in the sequence, the method returns true.</p>
 *
 * @param positions a {@code PositionSequence}
 * @return true if the positions in the specified sequence are counter-clockwise, or if the sequence contains
 * less than three elements.
 */
public static boolean isCounterClockwise(PositionSequence<?> positions) {
    if (positions.size() < 3) return true;
    Position p0 = positions.getPositionN(0);
    Position p1 = positions.getPositionN(1);
    double det = 0;
    int positionsSize = positions.size();
    int i = 2;
    while(i < positionsSize && det == 0) {
        Position p2 = positions.getPositionN(i);
        det = deltaDeterminant(p0, p1, p2);
        i++;
    }
    if (det == 0) {
        throw new IllegalArgumentException("Positions are collinear in 2D");
    }
    return det > 0;
}