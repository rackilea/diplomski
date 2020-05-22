Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(base)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
jsonApi jsonapi=retrofit.create(jsonApi.class);
Call<String> stringcall=jsonapi.getStringResponse(speech);
try {
    Response<String> response = stringcall.execute();
    String result = response.body();
} catch (Exception ex) { 
    //handle exception
}