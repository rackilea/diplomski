private static class CallbackHandler<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        int code = response.code();
        if (code >= 200 && code < 300) {
            onSuccess(response);
        } else if (code == 401) {
            // logic to refresh token or user then recall the same api
            call.clone().enqueue(this);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    public void onSuccess(Response<T> response) {

    }

}