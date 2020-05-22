@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK) {
        final int SELECT_PICTURE = 1; // Hardcoded from API
        if (requestCode == SELECT_PICTURE) {
            String pathToImage = data.getData().getPath(); // Get path to image, returned by the image picker Intent
            mDrawableBg = Drawable.createFromPath(pathToImage); // Get a Drawable from the path
        }
    }
}