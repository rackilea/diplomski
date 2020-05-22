private static String base_url = SharedPreferenceUtils.getString("URLS","");
 public static String BASE_URL = base_url;

/*** Create an instance of Retrofit object* */


      public static Retrofit getRetrofitInstance() {

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }