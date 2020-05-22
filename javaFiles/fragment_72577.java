for (Node element : gridpane.getChildren()) {
        element.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Row: " + GridPane.getRowIndex(element));
                System.out.println("Column: " + GridPane.getColumnIndex(element));
            }
        });
    }