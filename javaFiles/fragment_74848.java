@Override
public Iterator<Position> iterator()
{
    // must be final to be accessible from the iterator below
    final Position[] positions = computeReachablePositions();

    return new Iterator<Position>() {

        int index = 0;

        @Override
        public boolean hasNext()
        {
            return index < positions.length;
        }

        @Override
        public Position next()
        {
            if (hasNext())
            {
                Position value = positions[index];
                index++;
                return value;
            }
            throw new NoSuchElementException("No more positions available");
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("Removals are not supported");
        }};
}