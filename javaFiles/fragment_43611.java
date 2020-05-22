private Node getLowestFCost(List<Node> open) {
    int lowestCost = 0;
    int index = 0;
    for (int i = 0; i < open.size(); i++) {
        if (open.get(i).fCost <= lowestCost) {
            lowestCost = open.get(i).fCost;
            index = i;
        }
    }
    return open.get(index);
}