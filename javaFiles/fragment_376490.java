class Coordinate { 
    public Collection<Coordinate> getNeighbours() {
        List<Coordinate> neighbours = new ArrayList<>(6);
        for (Coordinate dir: getDirections()) {
            Coordinate n = new Coordinate(getRow() + dir.getRow(), getColumn() + dir.getColumn());
            if (n.isValid()) {
                neighbours.add(n);
            }
        }
        return neighbours;
    }
}