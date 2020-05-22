public class RequestTokenInterceptor implements Interceptor {
   @Override
   public Response intercept(Chain chain) throws IOException {
      Request request = chain.request();
      // Here where we'll try to refresh token.
      // with an retrofit call
      // After we succeed we'll proceed our request
      Response response = chain.proceed(request);
      return response;
   }
}