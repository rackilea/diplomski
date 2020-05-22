Retrofit retrofit = new Retrofit.Builder()
.addConverterFactory(GsonConverterFactory.create())
.baseUrl("https://{your base URL}/")
.build();

PostService mService = retrofit.create(PostService.class);