CopyStreamAdapter streamListener = new CopyStreamAdapter() {

    @Override
    public void bytesTransferred(long totalBytesTransferred, int bytesTransferred, long streamSize) {
       //this method will be called everytime some bytes are transferred

       int percent = (int)(totalBytesTransferred*100/yourFile.length());
       // update your progress bar with this percentage
    }

 });
ftp.setCopyStreamListener(streamListener);