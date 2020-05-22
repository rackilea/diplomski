Intent intent = getIntent();
    String posterUrl = intent.getStringExtra(Constants.EXTRA_URL);
    String title = intent.getStringExtra(Constants.TITLE_TEXT);
    String overview = intent.getStringExtra(Constants.OVERVIEW_TEXT);
    String releaseDate = intent.getStringExtra(Constants.RELEASE);
    String voteAverage = 
    intent.getStringExtra(Constants.VOTE_AVERAGE);
    final String movieId = intent.getStringExtra(MOVIE_ID);

    Movies movies = new Movies(movieId, posterUrl, title, overview, 
    releaseDate, voteAverage);

     mFavourites.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             addToFavourites(movies)//I don't know what to do here 
            Toast.makeText(DetailActivity.this, "Added to Favourites", 
            Toast.LENGTH_SHORT).show();
        }
    });