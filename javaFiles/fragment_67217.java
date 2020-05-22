public static void Bfs(Vertex source) {
    vertex = GraphifyGUI.getNode();
    reset();
    q = new LinkedList<>(); // FIFO
    source.wasVisited = true; // marked as visited
    q.add(source); // put into queue
    source.parent = source; // set parent
    conn = new ArrayList<>();
    while (!q.isEmpty()) { // source
        Vertex current = q.poll(); // remove first 
        conn.add(current.getId());
        Iterator<Vertex> currentList = current.vList().iterator();
        while (currentList.hasNext()) {
            Vertex next = currentList.next();
            if (next.wasVisited == false) {
                next.wasVisited = true;
                q.add(next);
                next.parent = current;
                GG.printlnConsole(next.getName() + " has type of " + next.getType());
            }
        }
    }
    GG.printlnConsole("Order is " + conn);
}