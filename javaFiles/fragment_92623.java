EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            CheckBox cb = (CheckBox) event.getSource();
            TableColumn column = (TableColumn) cb.getUserData();
            if (cb.isSelected()) {
                lstClm.add(column);
            } else {
                lstClm.remove(column);
            }
            for (TableColumn clm : lstClm) {
                System.out.println("selected column: " + clm.getText());
            }
        }
    };
    CheckBox cb = new CheckBox();
    cb.setUserData(firstDataColumn);
    cb.setOnAction(handler);
    firstDataColumn.setGraphic(cb);

    cb = new CheckBox();
    cb.setUserData(secondDataColumn);
    cb.setOnAction(handler);
    secondDataColumn.setGraphic(cb);