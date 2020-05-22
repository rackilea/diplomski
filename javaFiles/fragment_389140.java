public class UnauthorizedInterceptor implements Interceptor {
    private Callback mCallback;

    public UnauthorizedInterceptor(Callback callback) {
        mCallback = callback;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (originalResponse.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            mCallback.onUserLoggedOut();
        }

        return originalResponse;
    }

    interface Callback {
        void onUserLoggedOut();
    }
}