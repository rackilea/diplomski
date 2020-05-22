Platform.runLater(new Runnable() {
    @Override
    public void run() {
        Node n = listView1.lookup(".scroll-bar");
        if (n instanceof ScrollBar) {
            final ScrollBar bar = (ScrollBar) n;
            if (bar.getOrientation().equals(Orientation.VERTICAL)) {
                // get the second scrollbar of another listview and bind values of them
            }
        }
    }
});