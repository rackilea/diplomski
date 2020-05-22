public void resize_image(int w, int h) {
    Image im = Toolkit.getDefaultToolkit().getImage(IMG_PATH);
    waitForImage(im);
    /* ... */
    g.drawImage(im, 0, 0, w, h, null);
    /* ... */
}

private MediaTracker tracker = new MediaTracker(this);

private void waitForImage(Image image){
    tracker.addImage(image, 0);
    try {
        tracker.waitForID(0);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}