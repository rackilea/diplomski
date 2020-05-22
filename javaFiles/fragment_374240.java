private class loadDetails extends AsyncTask<Void,Void,Integer>() {

    @Override
    protected Integer doInBackground(Void... voids) {

        final Movie details = (Movie) getIntent().getExtras().getSerializable("MOVIE_DETAILS");
        int idMovie = details.getId();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/" + idMovie + "?api_key=" + API_KEY + "&language=en-US")
                .build();

        Response response = client.newCall(request).execute();
        JSONObject root = new JSONObject(response.body().string());

        int runtime = root.getInt("runtime");
        Log.i("test", runtime + " min");

        return runtime;
    }

    @Override
    protected void onPostExecute(Integer anInt) {
        yourTextView.setText("yourInt = " + anInt);
    }
}