for(int i=0;i<8;i++){
    for(int j=0;j<8;j++){
        //grid08(8X8)
        Pane p=new Pane();
        AtomicReference<Bounds> bounds = new AtomicReference<>(p.getBoundsInLocal());
        p.boundsInLocalProperty().addListener((obs, oldBounds, newBounds) -> bounds.set(newBounds));
        ImageView im=new ImageView();
        Label l=new Label("");
        im.fitWidthProperty().bind(p.widthProperty());
        im.fitHeightProperty().bind(p.heightProperty());
        l.prefWidthProperty().bind(p.widthProperty());
        l.prefHeightProperty().bind(p.heightProperty());
        p.getChildren().addAll(im,l);
        l.setVisible(false);
        l.setStyle("-fx-text-fill: #fff; -fx-font-size: 12px");
        l.setAlignment(Pos.CENTER);
        p.setStyle("-fx-background-color: black;");
        grid.add(p,j,i);//grid->instance of gridPane
        p.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if(!l.isVisible()){
                    event.acceptTransferModes(TransferMode.ANY);
                }
            }
        });
        p.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
               play(im,bounds,event.getDragboard().getString());
            }
        });
     }
 }