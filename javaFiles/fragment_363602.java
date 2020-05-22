cm  =new ContextMenu();
    MenuItem a = new MenuItem("A");
    MenuItem b = new MenuItem("B");
    MenuItem c = new MenuItem("C");
    cm.getItems().addAll(a,b,c);
    circle.setOnMouseClicked(new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent t) {
            if(t.getButton().toString().equals("SECONDARY"))
           cm.show(circle,t.getScreenX(),t.getSceneY());
        }
    });