//Declare this at the top of your class
final static private Map<String, Image> LOADED_URLS = new HashMap<>(); 

//Then change the URLImage image method to this
Display.getInstance().callSerially(() -> {
    EncodedImage roundPlaceholder = EncodedImage.createFromImage(tempPlaceholder, true);

    final Image reportImage = LOADED_URLS.containsKey(photoFilenameInStorage) ? LOADED_URLS.get(photoFilenameInStorage)
                        : URLImage.createToStorage(
                        roundPlaceholder,
                        photoFilenameInStorage,
                        currentReport.getPhotoPath(),
                        ParametresGeneraux.RESIZE_SCALE_WITH_ROUND_MASK
                );
    LOADED_URLS.put(photoFilenameInStorage, reportImage);
    myComponent.setIcon(reportImage);
    myComponent.getComponentForm().repaint();
});