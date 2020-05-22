String server = "192.168.1.145";
int port = 21;

@Override
protected void onPreExecute() {
    super.onPreExecute();

    CameraActivity.this.setProgressBarIndeterminateVisibility(true);

}


@Override
protected Void doInBackground(File... params) {
  try {
        ftpClient = new FTPClient();
        ftpClient.connect(server, port);
        ftpClient.login("marc", "1234");
        ftpClient.enterLocalPassiveMode();

        System.out.println("!>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    } catch (SocketException e) {
        this.cancel(true);
    } catch (IOException e) {
        this.cancel(true);
    }


    if(!this.isCancelled())
    {
        try 
        {

            InputStream item = null;

            try {
                item = new FileInputStream(params[0]);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            int streamSize = 0;
            while(item.read() != -1)
            {
                streamSize++;
            }

            InputStream is = new BufferedInputStream(item, streamSize);
            OutputStream os = ftpClient.storeFileStream("/test.jpg");

            Util.copyStream(is, os, streamSize, streamSize, new CopyStreamListener() {

                @Override
                public void bytesTransferred(long totalBytesTransferred, int bytesTransferred, long streamSize) {
                    publishProgress(new Long[] {totalBytesTransferred, streamSize});
                }

                @Override
                public void bytesTransferred(CopyStreamEvent event) {

                }
            });
            ftpClient.completePendingCommand();

            ftpClient.logout();
            ftpClient.disconnect();

        }
        catch (IOException e) {

        }
        catch (Exception e) {

        }
    }
    return null;
}


@Override
protected void onProgressUpdate(Long[]... values) {
    super.onProgressUpdate(values);
    Log.d("UPDATE", values[0] + " of " + values[1] + " copied.");
    //TODO Put code here
}

@Override
protected void onPostExecute(Void result) {
    // TODO Auto-generated method stub
    super.onPostExecute(result);
    CameraActivity.this.setProgressBarIndeterminateVisibility(false);
}