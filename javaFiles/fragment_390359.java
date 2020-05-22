Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
}