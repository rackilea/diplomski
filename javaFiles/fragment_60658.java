public void onModuleLoad() {

    // Make a new frame, and point it at Google.
    Frame frame = new Frame("http://www.google.com/");

    // Add it to the root panel.
    RootPanel.get("container").add(frame);

}