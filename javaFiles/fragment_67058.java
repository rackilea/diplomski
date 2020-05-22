@Override
protected void onStart() {
    super.onStart(); // Always call the superclass method first

    if (camera == null) {
        camera = Camera.open();
    }
            //flip the isflashon and then click the button
    isFlashOn = !isFlashOn;
    onClick(null);
}