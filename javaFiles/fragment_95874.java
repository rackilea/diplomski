Image img = new Image();
img.setUrl("SET YOUR URL");
img.addErrorHandler(new ErrorHandler() {
    @Override
    public void onError(ErrorEvent e){
        // Failed to load image
    }
});