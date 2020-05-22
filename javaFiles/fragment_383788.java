protected void writeImage() {           
SWTGraphics g = null;
GC gc = null;
Image image = null;
LayerManager lm = (LayerManager)getGraphicalViewer().getEditPartRegistry().get(LayerManager.ID);
IFigure figure = lm.getLayer(LayerConstants.PRINTABLE_LAYERS);

try {
    Rectangle r = figure.getBounds();
    image = new Image(Display.getDefault(), r.width, r.height);
    gc = new GC(image);
    g = new SWTGraphics(gc);
    g.translate(r.x * -1, r.y * -1);
    figure.paint(g);
    ImageLoader imageLoader = new ImageLoader();
    imageLoader.data = new ImageData[] {image.getImageData()};
    imageLoader.save(getImageSavePath(), SWT.IMAGE_JPEG);
    refreshProcessFolder();

} finally {
    //SNIP
}
}