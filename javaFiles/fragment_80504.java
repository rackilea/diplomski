public boolean dfsPath(int i) {
    this.path.add(i); // add current node to path
    if (i == this.sink) {
        return true; // if current node is sink, return true
                     // this.path contains nodes from source to sink
    }
    for (int j = 0; j < this.edgeCapacities.length; j++) {
        if (this.edgeCapacities[i][j] != 0 && ! this.path.contains(j)) {
            if (dfsPath(j)) {
                return true; // found a path -> search no further
            }
        }
    }
    this.path.remove(this.path.size() - 1); // pop last node
    return false; // no path found
}