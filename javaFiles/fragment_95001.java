List<Integer> toPositions(MenuItem i) {
    List<Integer> positions = new LinkedList<>();
    while (i != null) {
        position.addFirst(i.getPosition());
        i = i.getParent();
    }
    return positions;
}