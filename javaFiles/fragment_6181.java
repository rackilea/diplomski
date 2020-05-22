Pane parentPane = ... ;

BooleanBinding someVisibleChildren = new BooleanBinding() {


    {
        parentPane.getChildren().forEach(n -> bind(n.visibleProperty()));

        parentPane.getChildren().addListener((Change<? extends Node> c) -> {
            while (c.next()) {
               c.getAddedSubList().forEach(n -> bind(n.visibleProperty()));
               c.getRemoved().forEach(n -> unbind(n.visibleProperty())) ;
            }
        });

        bind(parentPane.getChildren());
    }

    @Override
    public boolean computeValue() {
        return parentPane.getChildren().stream()
            .filter(Node::isVisible)
            .findAny()
            .isPresent();
    }
}

parentPane.visibleProperty().bind(someVisibleChildren);