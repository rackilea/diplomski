Label label=new Label("guru ");
        label.getStylesheets().add("sample/styles/send.css");
        label.setId("receive");
        HBox hBox=new HBox();
        hBox.getChildren().add(label);
        hBox.setAlignment(Pos.BASELINE_RIGHT);
        vBox.getChildren().add(hBox);
        vBox.setSpacing(10);