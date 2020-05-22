ImageView image = findViewById(R.id.image);

if ((Boolean) image.getTag()) { // No image
    // Disable save button
    mBtnSave.setEnabled(false);
} else {
    mBtnSave.setEnabled(true);
}