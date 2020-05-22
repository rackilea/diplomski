public Node getNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {
    Node result = null;
    ObservableList<Node> childrens = gridPane.getChildren();
    for(Node node : childrens) {
        if(node instanceof Circle && gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
            result = node;
            break;
        }
    }
    return result;
}