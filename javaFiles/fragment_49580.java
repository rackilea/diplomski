public void createPartControl(Composite parent) {
    try {
        BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(getLocalByteArray()));
        ImageData imageData = new ImageData(inputStream);
        Image image = ImageDescriptor.createFromImageData(imageData).createImage();


        // Create the canvas for drawing
        Canvas canvas = new Canvas( parent, SWT.NONE);
        canvas.addPaintListener( new PaintListener() {
        public void paintControl(PaintEvent e) {
        GC gc = e.gc;
        gc.drawImage( image,10,10);
        }
        });