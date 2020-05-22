public int calculateWeight() {
    int weight = 0;
    for (Thing thing : things) {
        weight += thing.getWeight();
    }
    return weight;
}