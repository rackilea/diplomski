static Request originalRequest(okhttp3.Response response) {
  while (true) {
    okhttp3.Response prior = response.priorResponse();
    if (prior == null) {
      break;
    }
    response = prior;
  }
  return response.request();
}