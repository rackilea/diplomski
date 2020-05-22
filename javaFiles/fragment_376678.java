class GetFriendsInfo extends AsyncTask<Void, Void, JSONObject> {
    private String url;
    public GetFriendsInfo(String url_get_birthdays) {
        this.url = url_get_birthdays;
    }
    @Override
    protected JSONObject doInBackground(Void... params) {
        // Make your network call and get your JSONObject
        JSONObject jsonObject = jsonParser.makeHttpRequest(url_get_birthdays,"GET", param);

        return jsonObject;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        // Here you get your jsonObject on the main thread. You can  parse it and update your UI
        // Convert your jsonObject to what you want and then show the dialog


String[] from = {"names", "ids", "birthdays"};
        int[] to = {R.id.text1, R.id.im_ProfilePic, R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, birthday,   R.layout.listitem_birthday, from, to);
        HorizontalListView featuredList = (HorizontalListView) findViewById(R.id.lv_Birthdays);
        featuredList.setAdapter(adapter);

    }
}