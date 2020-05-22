InputStream inputStream = null;
if (ContentResolver.SCHEME_CONTENT.equals(selectedImage.getScheme())) {
    inputStream = context.getContentResolver().openInputStream(selectedImage);
} else if (ContentResolver.SCHEME_FILE.equals(selectedImage.getScheme())) {
    inputStream = new FileInputStream(selectedImage.getPath());
}

bitmap = BitmapFactory.decodeStream(inputStream);