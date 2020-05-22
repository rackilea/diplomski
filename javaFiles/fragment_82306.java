...

final Image image = new Image(attachmentUrl + CFeedPostAttachment.ATTACHMENT_FILE);
image.addLoadHandler(new LoadHandler() {
    @Override
    public void onLoad(LoadEvent event) {
        // since the image has been loaded, the dimensions are known
        popupImage.center(); 
        // only now show the image
        popupImage.setVisible(true);
    }
 });

 popupImage.add(image);
 // hide the image until it has been fetched
 popupImage.setVisible(false);
 // this causes the image to be loaded into the DOM
 popupImage.show();

 ...