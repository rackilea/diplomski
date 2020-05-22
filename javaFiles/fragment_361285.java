protected static class DownloadInfoOfWeather extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {

        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Accept", "*/*");

            connection.setDoOutput(true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            writer.write(params[1]);
            writer.close();

            connection.connect();

            // Response: 400
            Log.e("Response", connection.getResponseMessage() + "");

        } catch (Exception e) {
            Log.e(e.toString(), "Something with request");
        }

        return null;
    }
}