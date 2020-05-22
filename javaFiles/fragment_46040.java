@Override
protected void onActivityResult(int requestCode, final int resultCode, Intent data) {
    if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
        // Get a list of picked images
        List<Image> images = ImagePicker.getImages(data)
        // or get a single image only
        Image image = ImagePicker.getFirstImageOrNull(data)
    }
    super.onActivityResult(requestCode, resultCode, data);
}