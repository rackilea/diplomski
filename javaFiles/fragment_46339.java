public void setupNode(DragNode nde, String name){
    id = nde.getId();
    Command cmd = commandMap.get(name).get(); // <-- Calls the constructor             
    nodeList.add(new NodeList<String, String, Command>(name, id, cmd));

    nde.nodeLayout();
    rightAnchor.getChildren().add(nde);
    buildDragHandlers();
}