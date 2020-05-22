private boolean saveToInternalStorage(Bitmap image) {

    try {
        FileOutputStream fos = this.openFileOutput("profile.png", Context.MODE_PRIVATE);

        image.compress(Bitmap.CompressFormat.PNG, 100, fos);
        fos.close();

        return true;
    } catch (Exception e) {
        return false;
    }
}