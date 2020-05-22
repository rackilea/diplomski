MediaTracker tracker = new MediaTracker(new Canvas());
tracker.addImage(image, 0);
try {
    tracker.waitForAll();
}
catch (InterruptedException ex) {}