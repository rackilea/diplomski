@Override
    protected Boolean doInBackground(String... strings) {
        Boolean isSuccess = false;
        byte[] buffer = new byte[1024];
        try {
            RandomAccessFile raf = new RandomAccessFile(new File(_compressedFilePath), "r");
            raf.seek(raf.length() - 4);
            int b4 = raf.read();
            int b3 = raf.read();
            int b2 = raf.read();
            int b1 = raf.read();
            int uncompressedSize = ((0xFF & b1) << 24) | ((0xFF & b2) << 16) |
                    ((0xFF & b3) << 8) | (0xFF & b4);
            raf.close();

            GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(_compressedFilePath));
            FileOutputStream out = new FileOutputStream(_uncompressedFilePath);
            int count = 0;
            int len;
            while ((len = gzis.read(buffer)) > 0) {
                out.write(buffer, 0, len);
                count += len;
                publishProgress(count, uncompressedSize);
            }
            gzis.close();
            out.close();
            isSuccess = true;
        } catch (IOException ex) {
            Log.e("DecompressGzipAsync", "error unzipping file", ex);
        }
        return isSuccess;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int count = values[0];
        int uncompressedSize = values[1];
        int maxValue = progressBar.getMax();
        int progress = (int) ((float) count / (float) uncompressedSize * maxValue);
        if (progress > maxValue) progress = maxValue;  // sanity check
        progressBar.setProgress(progress);
        Log.v("DecompressGzipAsync", "Decompressing Progress... currentValue: " + progress + " | maxValue: " + maxValue);
    }