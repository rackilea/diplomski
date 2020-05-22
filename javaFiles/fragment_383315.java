Platform.runLater(new Runnable() {
    @Override
    public void run() {
        double position[] = new double[]{0.0d};
        Optional<ScrollBar> scroll = findScrollBar(tv, Orientation.VERTICAL);
        scroll.ifPresent(s -> position[0] = s.getValue());
        tv.setRoot(root);
        scroll.ifPresent(s -> s.setValue(position[0]));
    }
});

private Optional<ScrollBar> findScrollBar(TreeView<String> from, Orientation orientation) {
    Set<Node> nodes = from.lookupAll(".scroll-bar");
    return nodes.stream()
            .filter(node -> node instanceof ScrollBar && ((ScrollBar)node).getOrientation() == orientation)
            .map(node -> ((ScrollBar)node))
            .findFirst();
}