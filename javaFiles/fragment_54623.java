tabCover.addListener(SWT.Resize, new Listener() {
    public void handleEvent(Event event) {
        // Set images: cover_front
        int width = tabCover.getSize().x - 30;
        int height = tabCover.getSize().y - 30;
        Image buffer_Coverfront;

        buffer_Coverfront = new Image(Display.getDefault(), filename);
        Image old = lblCoverfront.getImage();
        lblCoverfront.setImage(Helper.ImageScale(buffer_Coverfront, width, height));
        buffer_Coverfront.dispose();
        buffer_Coverfront = null;

        if (old != null) old.dispose();

    } // handleEvent
}); // Listener