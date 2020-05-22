public void saveFile(String fileName, String path, InputStream objectData) throws Exception {
    DataOutputStream dos = null;
    OutputStream out = null;
    try {
        File newDirectory = new File(path);
        if (!newDirectory.exists()) {
            newDirectory.mkdirs();
        }

        File uploadedFile = new File(path, uploadFileName);
        out = new FileOutputStream(uploadedFile);
        byte[] fileAsBytes = new byte[inputStream.available()];
        inputStream.read(fileAsBytes);

        dos = new DataOutputStream(out);
        dos.write(fileAsBytes);
    } catch (IOException io) {
        io.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (out != null) {
                out.close();
            }
            if (dos != null) {
                dos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}