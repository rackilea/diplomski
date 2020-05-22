EventHandler boatHandler = new EventHandler<javafx.scene.input.MouseEvent>(){
        public void handle(javafx.scene.input.MouseEvent event){
        //code used for retrieving x,y values
        canvas.removeEventHandler(MouseEvent.MOUSE_PRESSED, this);

        }
}