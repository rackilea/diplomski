private static final Insets MARGIN = new Insets(10, 10, 15, 15);

...

// add standard elements...

getChildren().addListener((ListChangeListener.Change<? extends Node> c) -> {
    while (c.next()) {
        if (c.wasAdded()) {
             for (Node n : c.getAddedSubList()) {
                 GridPane.setColumnSpan(2);
                 GridPane.setRowIndex(1);
                 GridPane.setMargin(MARGIN);
             }
        } 
    }
});