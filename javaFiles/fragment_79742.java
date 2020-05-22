private boolean imageSaved = false;
public void run() {
    if(!imageSaved) {
        ByteBuffer buffer = mImage.getPlanes()[0].getBuffer();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        try (FileOutputStream output = new FileOutputStream(mFile)) {
            output.write(bytes);
            imageSaved = true;
            cameraHelper.fileSaved(mFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            mImage.close();
        }
    }
}