mRestService.getComicLatest(new Callback<Comic>() {

    private final Callback<Comic> outerAnon = this;

    @Override
    public void success(Comic comic, Response response) {
    }

    @Override
    public void failure(RetrofitError retrofitError) {
        mRetryFrame.findViewById(R.id.retry_button).setOnClickListener(
                new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mRestService.getComicLatest(outerAnon);
            }
        });
    }
});