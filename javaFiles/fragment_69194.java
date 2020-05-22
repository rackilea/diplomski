public void intercept(HttpRequest request) throws IOException {
lock.lock();
try {
  Long expiresIn = getExpiresInSeconds();
  // check if token will expire in a minute
  if (accessToken == null || expiresIn != null && expiresIn <= 60) {
    refreshToken();
    if (accessToken == null) {
      // nothing we can do without an access token
      return;
    }
  }
  method.intercept(request, accessToken);
} finally {
  lock.unlock();
}