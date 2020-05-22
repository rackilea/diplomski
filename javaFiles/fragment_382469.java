public Context mContext;
private MovieJSON mMovieData;
private ReviewJSON mMovieReviews;
private VideoJSON mMovieVideos;
public boolean mSortByMostPopular;
ITaskCompleteListener mTaskCompleteListener;

public FetchMovieData(Context context, boolean sortType, ITaskCompleteListener listener) {
    mContext = context;
    this.mSortByMostPopular = sortType;
    this.mTaskCompleteListener = listener;
}

public void getMovies() {
    new FetchMovies().execute();
}

public void getReviews() {
    new FetchReviews().execute();
}

public void getVideos() {
    new FetchTrailers().execute();
}

private class FetchMovies extends AsyncTask<String, Void, Void > {

    @Override
    protected Void doInBackground(String... params) {
        WebService service = new WebService();
        //TODO Re-Implement sorting
        mMovieData = service.getMovies();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(mMovieData != null)
            Constants.mMovies = MovieDataParser.getMovieData(mMovieData);

        mTaskCompleteListener.onTaskCompleted(); //Task completed alert UI that we have our data
    }
}

private class FetchReviews extends AsyncTask<String, Void, Void > {

    @Override
    protected Void doInBackground(String... params) {
        WebService service = new WebService();
        mMovieReviews = service.getReviews();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(mMovieReviews != null)
            Constants.mReviews = MovieDataParser.getReviewData(mMovieReviews);

        mTaskCompleteListener.onTaskCompleted(); //Task completed alert UI that we have our data
    }
}

private class FetchTrailers extends AsyncTask<String, Void, Void > {

    @Override
    protected Void doInBackground(String... params) {
        WebService service = new WebService();
        mMovieVideos = service.getVideos();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(mMovieVideos != null)
            Constants.mTrailers = MovieDataParser.getVideoData(mMovieVideos);

        mTaskCompleteListener.onTaskCompleted(); //Task completed alert UI that we have our data
    }
}