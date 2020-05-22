public void resize_image(int w, int h) {
    Image im = Toolkit.getDefaultToolkit().getImage(IMG_PATH);
    /* ... */
    g.drawImage(im, 0, 0, w, h, null);
    /* ... */
}