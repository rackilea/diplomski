// First create the factory
JsonAdapter.Factory jsonApiAdapterFactory = ResourceAdapterFactory.builder()
  .add(TokenModel.class)
  .build();

// Create a custom moshi instacne
Moshi moshi = new Moshi.Builder()
  .add(jsonApiAdapterFactory)
  .build();

// Add the custom moshi instance to Retrofits Converter Factory
Retrofit refRetrofit = new Retrofit.Builder()
  .baseUrl(ClientConfigs.BASE_URL)
  .client(httpClient)
  .addConverterFactory(MoshiConverterFactory.create(moshi))
  .build();