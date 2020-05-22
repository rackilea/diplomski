InputStream imageStream = null;
try {
    imageStream = getContentResolver().openInputStream(selectedImage);
} catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}