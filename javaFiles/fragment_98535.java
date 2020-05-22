private TabPane findTabPaneForNode(Node node) {
    TabPane tabPane = null ;

    for (Node n = node.getParent(); n != null && tabPane == null; n = n.getParent()) {
        if (n instanceof TabPane) {
            tabPane = (TabPane) n;
        }
    }

    return tabPane ;
}