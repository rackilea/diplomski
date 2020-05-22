root.getChildren().addAll(pane1, pane2, pane3);

// set opacity for all but the last child to 0
List<Node> children = root.getChildren();
for (int i = children.size()-2; i >= 0; i--) {
    children.get(i).setOpacity(0);
}