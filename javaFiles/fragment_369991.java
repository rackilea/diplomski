long total = 0;
int maxBufferSize = 8192; // at least. 512 is far too small.
while ((bytesRead = fileInputStream.read(buffer, 0, bufferSize)) > 0) {
    dataOutputStream.write(buffer, 0, bytesRead);
    total += bytesRead;
    final long uploadedBytes = total;

    activity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
            progressDialog.setProgress(uploadedBytes);
                }
        });
    }
}
// at this point we are at end of stream
activity.runOnUiThread(new Runnable() {
    @Override
    public void run() {
progressDialog.setMessage(activity.getString(R.string.camera_uploading_done));
    }
}