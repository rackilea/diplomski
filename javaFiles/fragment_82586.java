public int compare(Node a, Node b) {
    if (a.getLatency() < b.getLatency())
        return -1;
    else if (a.getLatency() > b.getLatency())
        return 1;
    return 0;
}