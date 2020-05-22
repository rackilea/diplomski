Log.d("okhttphandleruserreg", "called");

// here you create your request body as as a Form one
RequestBody formBody = new FormBody.Builder()
  .add("name", "test")
  .add("email", "test@domain.com")
  .add("username", "test")
  .add("username", "test")
  .add("month", "january")
  .add("dayOfMonth", "1")
  .build();

Request request = new Request.Builder()
  .url(params[0])
  .post(formBody)
  .build();

// call your request