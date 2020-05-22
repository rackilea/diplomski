void drawSomething(GraphicalEdge edge) {
    GraphicalNode n0 = edge.getNode();
    GraphicalNode n1 = edge.getNode();
    ...
}

void run() {
    GraphicialEdge e = new GraphicalEdge(...);

    computeSomething(e); // Works
    drawSomething(e); // Works as well

    Edge edge = e;
    drawSomething(edge); // Does not work. A GraphicalEdge is required.
}