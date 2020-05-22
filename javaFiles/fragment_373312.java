private void initializeMoveOnClick(final Group window){
    window.addEventFilter(MouseEvent.MOUSE_CLICKED, this::eventFilter);
}
private void eventFilter(MouseEvent e) {
    //do some stuff
}