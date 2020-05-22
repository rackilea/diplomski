Platform.runLater(new Runnable() {

    @Override
    public void run() {
        listView.scrollTo(N);
        listView.getSelectionModel().select(N);
    }
});