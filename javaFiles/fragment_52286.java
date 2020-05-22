public void returnToResults() {
    Platform.runLater(() -> {
        vbox.getChildren.clear();
        vbox.getChildren.addAll(results);

        scroll.layout();

        scroll.setVvalue(vValue); 
        returnToResults.setDisable(true);
    });
}