HBox bottomPanel = new HBox();
bottomPanel.setAlignment(Pos.CENTER);

Region padderRegion1 = new Region();
Region padderRegion2 = new Region();
Region padderRegion3 = new Region();
padderRegion1.prefWidthProperty().bind(diffLabel.widthProperty().add(diffBox.widthProperty()));

bottomPanel.getChildren().addAll(padderRegion1, padderRegion2, playBtn, padderRegion3, diffLabel, diffBox);
HBox.setHgrow(padderRegion2, Priority.ALWAYS);
HBox.setHgrow(padderRegion3, Priority.ALWAYS);