public void loadHTML(View vL) {
    new getCode().execute();
}

private class getCode extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        final String ss = (et.getText().toString());
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(ss));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();
                Log.v("DYRA BYRA", responseString);
            } else {
                response.getEntity().getContent().close();
            }
        } catch (Exception e) {

        }
        return null;

    }

    protected void onPostExecute(String result) {
        tvW.setText(responseString);
    }

}