Label label=new Label(msg);
        label.getStylesheets().add("sample/styles/send.css");
        label.setId("send");
        HBox hBox=new HBox();
        hBox.getChildren().add(label);
        hBox.setAlignment(Pos.BASELINE_LEFT);
        vBox.getChildren().add(hBox);
        vBox.setSpacing(10);