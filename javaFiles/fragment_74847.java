@Override
public Iterator<Position> iterator()
{
    // make sure this returns e.g. Collections.unmodifiableList
    Collection<Position> positions = computeReachablePositions(); 
    return positions.iterator();
 }