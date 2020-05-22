DragSource source = DragSource.getDefaultDragSource();
DragSourceMotionListener dsml = new DragSourceMotionListener() {

    @Override
    public void dragMouseMoved(DragSourceDragEvent dsde) {
        debug(dsde);
    }
};
source.addDragSourceMotionListener(dsml);

// just some logging
protected void debug(DragSourceEvent dsde) {
    DragSourceContext context = dsde.getDragSourceContext();
    Component source = context.getComponent();
    String text = source != null ? source.getName() : "none";
    LOG.info(text + " x/y " + dsde.getX() + "/" + dsde.getY());
}