private class ContentViewImgUrl extends AsyncTask<String,String,String> {

    final Pattern pattern = Pattern.compile("url\\((.+?)\\)");

    @Override
    protected void onPreExecute() {}

    @Override
    protected String doInBackground(String... params) {

        try {
            final Document doc = Jsoup.connect(URL).timeout(30000).get();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String url = doc.getElementById("content_heading").attr("style").toString();
                    Matcher matcher = pattern.matcher(url);
                    matcher.find();
                    System.out.println(matcher.group(1));
                }
            });
        } catch (Exception e) {
            Log.e("ESEMPIO", "ERROR");
        }
        return null; // MODIFIED HERE
    }

    @Override
    protected void onPostExecute(String result) {   
        Toast.makeText(SingleActivity.this, "url "+ imgUrlPost, Toast.LENGTH_SHORT).show();
    }
}