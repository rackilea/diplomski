@Override
public void onResponse(Response<MovieResults> response, Retrofit retrofit1) {
       MovieResults movieResults = response.body();
       if (movieResults != null) {
            movieArrayList = (ArrayList<Movie>) movieResults.getResults();
            movieAdapter.clear();// no need for this line in the first call
            movieAdapter.addAll(movieArrayList);
            movieAdapter.notifyDataSetChanged();
        }

        // ....
 }