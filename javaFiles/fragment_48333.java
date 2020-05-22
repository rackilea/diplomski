ObservableMap<Point, Sheep> allSheep = FXCollections.observableHashMap();
GridPane gameView = new GridPane();
allSheep.addListener((Change<? extends Point, ? extends Sheep> c) -> {
    if (c.wasAdded()) {
        Point location = c.getKey();
        Sheep addedSheep = c.getValue();
        gameView.add(addedSheep.getView(), location.x, location.y);
    } else if (c.wasRemoved()) {
        Sheep removedSheep = c.getValue();
        gameView.getChildren().remove(removedSheep.getView());
    }
}