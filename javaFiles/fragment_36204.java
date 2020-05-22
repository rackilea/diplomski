private void save(Bitmap bitmap) {
    FileOutputStream fos = null;
    try {
        fos = new FileOutputStream(path);
        bitmap.compress(Bitmap.CompressFormat.JPEG, COMPRESSION_QUALITY, fos);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (fos != null) {
            fos.close();
        }
    }
}