public abstract class DefaultRequestCallback<T> implements Callback<T> {

    public abstract void failure(YourCustomException ex);

    public abstract void success(T responseBean);

    @Override
    public void success(T baseResponseBean, Response response) {
        if (response == null) {
            // Here we catch null response and transform it to our custom     Exception
            failure(new YourCustomException());
        }
        } else {
            success(baseResponseBean);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        // Here's your failure method.
        // Also you can transform default retrofit errors to your customerrors
        YourCustomException ex = new YourCustomException();
        failure(ex);
    }
}