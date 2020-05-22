for (Node node : listView.lookupAll(".scroll-bar")) {
    if (node instanceof ScrollBar) {
        ScrollBar scrollBar = (ScrollBar) node;
        scrollBar.visibleProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(String.format("%s ScrollBar Visible Property Changed From: %s To: %s", scrollBar.getOrientation(), oldValue, newValue));
        });
    }
}