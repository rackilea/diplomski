public class VideoCompressAsyncTask extends AsyncTask<String, String, String> {

    Context mContext;

    public VideoCompressAsyncTask(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialogUpload = new ProgressDialog(getActivity());
        dialogUpload.setCancelable(false);
        dialogUpload.setMessage("Please wait until the video upload is complete");
        dialogUpload.show();
    }

    @Override
    protected String doInBackground(String... paths) {
        String filePath = null;
        try {
            String path = paths[0];
            String directoryPath = paths[1];
            filePath = SiliCompressor.with(mContext).compressVideo(path, directoryPath);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return filePath;
    }


    @Override
    protected void onPostExecute(String compressedFilePath) {
        super.onPostExecute(compressedFilePath);
        File imageFile = new File(compressedFilePath);
        ByteArrayOutputStream byteBuffer;

        float length = imageFile.length() / 1024f; // Size in KB
        String value;
        if (length >= 1024)
            value = length / 1024f + " MB";
        else
            value = length + " KB";

        String text = String.format(Locale.US, "%s\nName: %s\nSize: %s", getString(R.string.video_compression_complete), imageFile.getName(), value);
        Log.e(TAG, "text: " + text);
        Log.e(TAG, "imageFile.getName() : " + imageFile.getName());
        Log.e(TAG, "Path 0 : " + compressedFilePath);

        try {
            File file = new File(compressedFilePath);
            InputStream inputStream = null;//You can get an inputStream using any IO API
            inputStream = new FileInputStream(file.getAbsolutePath());
            byte[] buffer = new byte[8192];
            int bytesRead;
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            Base64OutputStream output64 = new Base64OutputStream(output, Base64.DEFAULT);
            VideoUri = Uri.fromFile(file);
            try {
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    output64.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            output64.close();
            ba1 = output.toString();
            // Here video size is reduce and call your method to upload file on server
            uploadVideoMethod();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}