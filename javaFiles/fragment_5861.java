private class SendPostRequest extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {

        String postData = "";

        HttpURLConnection httpConnection= null;
        try {

            httpConnection= (HttpURLConnection) new URL(params[0]).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            DataOutputStream outputStream= new DataOutputStream(httpURLConnection.getOutputStream());
            outputStream.writeBytes("PostData=" + params[1]);
            outputStream.flush();
            outputStream.close();

            InputStream in = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(in);

            int inputStreamData = inputStreamReader.read();
            while (inputStreamData != -1) {
                char currentData = (char) inputStreamData;
                inputStreamData = inputStreamReader.read();
                postData += currentData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpConnection!= null) {
                httpURLConnection.disconnect();
            }
        }
        return postData;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }
}