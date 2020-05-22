for(Node node : lineChart.lookupAll("Label.chart-legend-item")){

    Label label = (Label)node;
    label.getGraphic().setStyle("-fx-background-color: " + mycolor + ", white");

    legendBox.getChildren().add(node);
    HBox.setMargin(node, insets);

}