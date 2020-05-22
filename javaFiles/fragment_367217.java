@Override
    public void onModuleLoad() {

    final Image image = new Image("https://www.google.com/images/srpr/logo3w.png");
    image.addLoadHandler(new LoadHandler() {

        @Override
        public void onLoad(LoadEvent event) {
            Window.alert(image.getWidth() + " " + image.getHeight());
        }
    });
    RootLayoutPanel.get().add(image);
    }