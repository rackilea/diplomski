public class UploadUtil extends SwingWorker<Void, Void> {

    String paTU;
    ChannelSftp csftp;

    public UploadUtil(String pathToUl, ChannelSftp chaSftp) {
        paTU = pathToUl;
        csftp = chaSftp;
    }

    @Override
    public void doInBackground() throws Exception {
        try {
            csftp.put(paTU, LoginAndFunctions.sftpWorkingDir, new SystemOutProgressMonitor());
        } catch (SftpException e) {
            Error errorUploading = new Error(e.toString()+"\nUploadpipe closed unexpectedly");
            errorUploading.setVisible(true);
        }
    }
}