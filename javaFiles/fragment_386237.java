this.title = (TextView) findViewById(R.id.main_title);

new AsyncTask<Void, Void, String>() {
    @Override
    protected String doInBackground(Void... params) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements storyTitle = doc.getElementsByClass("story_item_title");
            return storyTitle.attr("content");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override 
    public void onPostExecute(String content) {
        MainActivity.this.title.setText(content);
    } 
}.execute();