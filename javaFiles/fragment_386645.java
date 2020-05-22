private void onCaptureImageResult(Intent data) {

    beginCrop(data.getData());
}

@SuppressWarnings("deprecation")
private void onSelectFromGalleryResult(Intent data) {
    Uri selectedImageUri = data.getData();

    beginCrop(selectedImageUri);
}

private void beginCrop(Uri source) {
    Uri destination = Uri.fromFile(new File(getCacheDir(), "cropped"));
    Crop.of(source, destination).asSquare().start(this);
}

private void handleCrop(int resultCode, Intent result) {
    if (resultCode == RESULT_OK) {

        try {
            Bitmap bitmap = handleSamplingAndRotationBitmap(this, Crop.getOutput(result));

            saveToInternalStorage(bitmap);

            mUserProfilePhoto.setImageBitmap(readFromInternalStorage("profile.png"));
        }catch (IOException e){ /* do nothing here */}
    } else if (resultCode == Crop.RESULT_ERROR) {
        Toast.makeText(this, Crop.getError(result).getMessage(), Toast.LENGTH_SHORT).show();
    }
}