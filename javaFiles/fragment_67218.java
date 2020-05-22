public void shortestPath(int v, int e) {
    if (e == v) {
        GG.printlnConsole(v + "-->" + v);
        return;
    }
    for (int i = e; i >= 0; i = vertex.get(i).getParent().getId()) {
        if (i == v) {
            break;
        }
        if (vertex.get(i).getParent().getId() != -1) {
            set.put(vertex.get(i).getParent().getId(), i);
        }
    }
}