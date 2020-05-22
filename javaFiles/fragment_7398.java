addPaintListener(new PaintListener() {
    public void paintControl(PaintEvent e) {
        e.gc.setAlpha(50);
        e.gc.drawImage(image1, 0, 0);
        e.gc.setAlpha(100);
        e.gc.drawImage(image2, 0, 0);
    }
});