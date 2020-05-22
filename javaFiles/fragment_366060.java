private JokeListAdapter jokeListAdapter;
@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        jokeListAdapter = new JokeListAdapter();
        setListAdapter(jokeListAdapter);
        call = service.jokes();
        call.enqueue(new retrofit2.Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                if(response.isSuccessful()) {
                    List<Joke> jokes = response.body();
                    Log.e(TAG, "response is successful");
                    jokeListAdapter.setValue(jokes);
                    //setListAdapter(new JokeListAdapter(jokes));
                    Log.e(TAG, "response is successful");
                } else {
                    Log.e(TAG, "response is not successful");
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                Log.e(TAG, "response on failure");
            }
        });
}