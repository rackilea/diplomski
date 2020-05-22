public class SendFile extends AsyncTask<String, Integer, Integer> {

    private Context conT;
    private ProgressDialog dialog;
    private String SendUrl = "";
    private String SendFile = "";
    private String Parameters = "";
    private String result;
    public File file;

    SendFile(Context activity, String url, String filePath, String values) {
        conT = activity;
        dialog = new ProgressDialog(conT);
        SendUrl = url;
        SendFile = filePath;
        Parameters = Values;
    }

    @Override
    protected void onPreExecute() {
        file = new File(SendFile);
        dialog.setMessage("Please Wait..");
        dialog.setCancelable(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMax((int) file.length());
        dialog.show();
    }

    @Override
    protected Integer doInBackground(String... params) {
        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;
        InputStream inputStream = null;
        String twoHyphens = "--";
        String boundary = "*****"
                + Long.toString(System.currentTimeMillis()) + "*****";
        String lineEnd = "\r\n";

        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 512;

        String[] q = SendFile.split("/");
        int idx = q.length - 1;
        try {

            FileInputStream fileInputStream = new FileInputStream(file);

            URL url = new URL(SendUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("User-Agent",
                    "Android Multipart HTTP Client 1.0");
            connection.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + boundary);

            outputStream = new DataOutputStream(
                    connection.getOutputStream());
            outputStream.writeBytes(twoHyphens + boundary + lineEnd);
            outputStream
                    .writeBytes("Content-Disposition: form-data; name=dosya; filename=\""
                            + q[idx] + "\"" + lineEnd);
            outputStream.writeBytes("Content-Type: image/jpg" + lineEnd);
            outputStream.writeBytes("Content-Transfer-Encoding: binary"
                    + lineEnd);
            outputStream.writeBytes(lineEnd);

            bytesAvailable = fileInputStream.available();
            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            int boyut = 0;
            while (bytesRead > 0) {
                boyut += bytesRead;
                outputStream.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                dialog.setProgress(boyut);
            }

            outputStream.writeBytes(lineEnd);

            String[] posts = Bilgiler.split("&");
            int max = posts.length;
            for (int i = 0; i < max; i++) {
                outputStream.writeBytes(twoHyphens + boundary + lineEnd);
                String[] kv = posts[i].split("=");
                outputStream
                        .writeBytes("Content-Disposition: form-data; name=\""
                                + kv[0] + "\"" + lineEnd);
                outputStream.writeBytes("Content-Type: text/plain"
                        + lineEnd);
                outputStream.writeBytes(lineEnd);
                outputStream.writeBytes(kv[1]);
                outputStream.writeBytes(lineEnd);
            }

            outputStream.writeBytes(twoHyphens + boundary + twoHyphens
                    + lineEnd);
            inputStream = connection.getInputStream();
            result = this.convertStreamToString(inputStream);
            Log.v("TAG","result:"+result);
            fileInputStream.close();
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        dialog.setProgress(progress[0]);
    }

    @Override
    protected void onPostExecute(Integer result1) {
        dialog.dismiss();
    };

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }