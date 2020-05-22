ScrollPane scrollPane;
// ...
if (scrollPane.getSkin() == null) {
    // Skin is not yet attached, wait until skin is attached to access the scroll bars
    ChangeListener<Skin<?>> skinChangeListener = new ChangeListener<Skin<?>>() {
        @Override
        public void changed(ObservableValue<? extends Skin<?>> observable, Skin<?> oldValue, Skin<?> newValue) {
            scrollPane.skinProperty().removeListener(this);
            accessScrollBar(scrollPane);
        }
    };
    scrollPane.skinProperty().addListener(skinChangeListener);
} else {
    // Skin is already attached, just access the scroll bars
    accessScrollBar(scrollPane);
}

private void accessScrollBar(ScrollPane scrollPane) {
    for (Node node : scrollPane.lookupAll(".scroll-bar")) {
        if (node instanceof ScrollBar) {
            ScrollBar scrollBar = (ScrollBar) node;
            if (scrollBar.getOrientation() == Orientation.HORIZONTAL) {
                // Do something with the horizontal scroll bar

                // Example 1: Print scrollbar height
                // System.out.println(scrollBar.heightProperty().get());

                // Example 2: Listen to visibility changes
                // scrollBar.visibleProperty().addListener((observable, oldValue, newValue) -> {
                //     if(newValue) {
                //         // Do something when scrollbar gets visible
                //     } else {
                //         // Do something when scrollbar gets hidden
                //     }
                // });
            }
            if (scrollBar.getOrientation() == Orientation.VERTICAL) {
                // Do something with the vertical scroll bar
            }

        }
    }
}