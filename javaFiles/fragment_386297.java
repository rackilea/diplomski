InvalidationListener listener = new InvalidationListener(){
    @Override
    public void invalidated(Observable o) {
        redraw();       
    }           
});
canvas.widthProperty().addListener(listener);
canvas.heightProperty().addListener(listener);