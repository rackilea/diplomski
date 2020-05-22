public void addSelectionControlToNode(Node node) {
    node.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
        if (e.isControlDown()) {
            if (selection.contains(node)) {
                selection.remove(node);
                node.pseudoClassStateChanged(SELECTED_PSEUDO_CLASS, false);
            } else {
                selection.add(node);
                node.pseudoClassStateChanged(SELECTED_PSEUDO_CLASS, true);
            }
        } else {
            selection.clear();
            selection.add(node);
            node.pseudoClassStateChanged(SELECTED_PSEUDO_CLASS, true);
        }
        System.out.println(selection.size());
    });
}