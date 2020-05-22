public class MovieAddFromWeb extends Activity implements View.OnClickListener, OnItemClickListener {

private TextView searchBox;
private Button bGo, bCancelAddFromWeb;
private ListView moviesList;
public List<String> movieTitles;

//added new variables
public List<String> movieSynopsis;
public List<String> movieImgUrl;


static final int ACTIVITY_WEB_ADD = 3;

// the Rotten Tomatoes API key
private static final String API_KEY = "8q6wh77s65aw435cab9rbzsq";

// the number of movies to show in the list
private static final int MOVIE_PAGE_LIMIT = 8;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.movie_add_from_web);

    InitializeVariables();

}

/*
 * Initializing the variables and creating the bridge between the views from
 * the xml file and this class
 */

private void InitializeVariables() {

    searchBox = (EditText) findViewById(R.id.etSearchBox);
    bGo = (Button) findViewById(R.id.bGo);
    bCancelAddFromWeb = (Button) findViewById(R.id.bCancelAddFromWeb);
    moviesList = (ListView) findViewById(R.id.list_movies);

    bGo.setOnClickListener(this);
    bCancelAddFromWeb.setOnClickListener(this);
    moviesList.setOnItemClickListener(this);
}

@Override
public void onClick(View v) {
    switch (v.getId()) {

    case R.id.bGo:
        new RequestTask()
                .execute("http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey="
                        + API_KEY
                        + "&q="
                        + searchBox.getText()
                        + "&page_limit=" + MOVIE_PAGE_LIMIT);
        break;

    case R.id.bCancelAddFromWeb:
        finish();
        break;

    }

}

private void refreshMoviesList(List<String> movieTitles) {
    moviesList.setAdapter(new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, movieTitles
                    .toArray(new String[movieTitles.size()])));
}

private class RequestTask extends AsyncTask<String, String, String> {
    // make a request to the specified url
    @Override
    protected String doInBackground(String... uri) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response;
        String responseString = null;
        try {
            // make a HTTP request
            response = httpclient.execute(new HttpGet(uri[0]));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();
            } else {
                // close connection
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (Exception e) {
            Log.d("Test", "Couldn't make a successful request!");
        }
        return responseString;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);

        try {
            // convert the String response to a JSON object
            JSONObject jsonResponse = new JSONObject(response);

            // fetch the array of movies in the response
            JSONArray jArray = jsonResponse.getJSONArray("movies");

            // add each movie's title to a list
            movieTitles = new ArrayList<String>();

            //newly added
            movieSynopsis = new ArrayList<String>();
            movieImgUrl= new ArrayList<String>();

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject movie = jArray.getJSONObject(i);
                movieTitles.add(movie.getString("title"));


                movieSynopsis.add(movie.getString(#add the synopsis var name returned by the JSON));
                movieImgUrl.add(movie.getString(#add the urlvar name returned by the JSON));


            }
            // refresh the ListView
            refreshMoviesList(movieTitles);
        } catch (JSONException e) {
            Log.d("Test", "Couldn't successfully parse the JSON response!");
        }
    }
}

@Override
public void onItemClick(AdapterView<?> av, View view, int position, long id) {

    Intent openMovieEditor = new Intent(this, MovieEditor.class);
    openMovieEditor.putExtra("movieTitle", movieTitles.get(position));

    //newly added
    openMovieEditor.putExtra("movieSynopsis", movieSynopsis.get(position));
    openMovieEditor.putExtra("movieImgUrl", movieImgUrl.get(position));


    openMovieEditor.putExtra("callingActivity", ACTIVITY_WEB_ADD);
    startActivityForResult(openMovieEditor, ACTIVITY_WEB_ADD);

}