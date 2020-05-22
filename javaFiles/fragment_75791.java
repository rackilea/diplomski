dragSource.addDragListener(new DragSourceListener() {
    @Override
    public void dragStart(DragSourceEvent dragSourceEvent) {
        // getting control widget - Composite in this case
        Composite composite = (Composite) ((DragSource) dragSourceEvent.getSource()).getControl();
        // Getting dimensions of this widget
        Point compositeSize = composite.getSize();
        // creating new GC
        GC gc = new GC(composite);
        // Creating new Image
        Image image = new Image(Display.getCurrent(),compositeSize.x,compositeSize.y);
        // Rendering widget to image
        gc.copyArea(image,0,0);
        // Setting widget to DnD image
        dragSourceEvent.image = image;
    }
... other overriden methods ...
}