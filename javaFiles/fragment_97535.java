for(Node node : lineChart.lookupAll("Label.chart-legend-item")){

    legendBox.getChildren().add(node);
    HBox.setMargin(node, insets);

}