p.setOnMouseClicked(new EventHandler <MouseEvent> (){
        @Override
        public void handle(MouseEvent me){
            double posX = me.getX();
            double posY = me.getY();

            int colX = (int)(posX / width);
            int colY = (int) (posY / width);

            rec[colX][colY].setFill(Color.RED);
        }
    });