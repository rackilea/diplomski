private void save(Bitmap bitmap) {
    try (FileOutputStream fos = new FileOutputStream(path)) {
        bitmap.compress(Bitmap.CompressFormat.JPEG, COMPRESSION_QUALITY, fos);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}