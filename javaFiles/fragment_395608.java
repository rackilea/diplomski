TextField1.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(5));

AutoControl.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

            TextField1.clear();    
}