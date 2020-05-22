RestAdapter mRetrofit;

MovieDBService mService;

public WebService() {
    mRetrofit = new RestAdapter.Builder()
            .setEndpoint("http://api.themoviedb.org")
            .build();
    mService = mRetrofit.create(MovieDBService.class);
}

public MovieJSON getMovies() {
    return mService.listMovies("");
}

public ReviewJSON getReviews() {
    return mService.listReviews("76341");
}

public VideoJSON getVideos() {
    return mService.listVideos("76341");
}