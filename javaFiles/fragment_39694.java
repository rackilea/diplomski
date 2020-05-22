addConnection(ElementBean element) {
    if (element ==null) { 
        throw new IllegalArgumentException("cannot add null element"); 
    }
    connections.add(element);
    element.getConnections0().add(this);
}