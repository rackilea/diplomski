scn.setOnKeyPressed(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.D) {
                System.out.print("Move Right");
            } else if (event.getCode() == KeyCode.A) {
                System.out.print("Move left");
            }
            event.consume();
        }
    });