Request templateRequest = new Request.Builder()
  .url("https://www.example.com/")
  .addHeader(...)
  .build();
Request stackoverflowRequest = templateRequest.newBuilder()
  .url("https://www.stackoverflow.com/")
  .build();
Request googleRequest = templateRequest.newBuilder()
  .url("https://www.google.com/")
  .build();