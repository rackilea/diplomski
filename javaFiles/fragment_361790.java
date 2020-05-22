/**
 * downloadVideoAsyntask aysnctask is used to download video from server.
 */

class DownlaodVideoAsyntask extends AsyncTask<String, String, Boolean> {

    protected void onPreExecute() {
        Utils.showProgressDialog(mActivity, "Downloading...", false);
        isAsyntaskWorking = true;
    };

    protected void onProgressUpdate(String... values) {

        Utils.showLog(TAG, values[0]);
    };

    @Override
    protected Boolean doInBackground(String... params) {

        final int TIMEOUT_CONNECTION = 5000;// 5sec
        final int TIMEOUT_SOCKET = 30000;// 30sec
        String imageURL = params[0];
        Utils.showLog(TAG, imageURL);
        URL url = null;
        try {
            url = new URL(imageURL);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long startTime = System.currentTimeMillis();
        Log.i(TAG, "image download beginning: " + imageURL);

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/" + AppHelper.STORED_VIDEO_PATH);
        if (!myDir.exists()) {
            myDir.mkdirs();
        }

        String fname = System.currentTimeMillis() + ".avi";
        file = new File(myDir, fname);

        // Open a connection to that URL.
        URLConnection ucon = null;
        try {
            ucon = url.openConnection();
            lengthofFile = ucon.getContentLength();
            Utils.showLog("ANDRO_ASYNC", "Length of file: " + lengthofFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // this timeout affects how long it takes for the app to realize
        // there's
        // a connection problem
        ucon.setReadTimeout(TIMEOUT_CONNECTION);
        ucon.setConnectTimeout(TIMEOUT_SOCKET);

        // Define InputStreams to read from the URLConnection.

        InputStream is = null;
        try {
            is = ucon.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedInputStream inStream = new BufferedInputStream(is);
        // new BufferedInputStream(is, 1024 * 18);
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buff = new byte[5 * 1024];

        long total = 0;

        // Read bytes (and store them) until there is nothing more to
        // read(-1)
        int len;
        try {
            while ((len = inStream.read(buff)) != -1) {
                total += len;
                publishProgress("" + (int) ((total * 100) / lengthofFile));
                outStream.write(buff, 0, len);
            }

            // clean up
            outStream.flush();
            inStream.close();
            outStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i(TAG, "download completed in "
                + ((System.currentTimeMillis() - startTime) / 1000)
                + " sec");
        return false;
    }

    protected void onPostExecute(Boolean result) {

        Utils.hideProgressDialog();
        isAsyntaskWorking = false;
        if (result) {
            // if successfully download the video.
            Utils.showToast(mActivity,
                    getResources().getString(R.string.toast_video_success));
        } else {
            Utils.showToast(mActivity,
                    getResources().getString(R.string.toast_video_fail));

            // deleting partially downloaded file.
            file.delete();
        }
    };

}