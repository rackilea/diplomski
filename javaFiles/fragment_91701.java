public void upload(File file) throws IOException {
    ChannelSftp c = (ChannelSftp) channel;
    BufferedInputStream bis = new BufferedInputStream(file.toInputStream());
    SftpException sftpException = null;
    try {
        String uploadLocation = Files.simplifyPath(this.fileLocation + "/" + file.getName());
        c.put(bis, uploadLocation);
    } catch (SftpException e) {
        sftpException = e;
        throw new IllegalTargetException("Error occurred while uploading " + e.getMessage());
    } finally {
        if (sftpException != null) {
            try {
                bis.close();
            } catch (Throwable t) {
                sftpException.addSuppressed(t);
            }
        } else {
            bis.close();
        }
    }
}