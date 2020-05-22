public interface SampleApi {
    @POST("sample-endpoint")
    Call<ApiResponse> postThing(@Body RequestBody hexEncodedData,
                                @Header(HttpHeaders.DATE) String gmtDateStr,
                                @Header("X-CUSTOM-ONE") long custom1,
                                @Header("X-CUSTOM-TWO") String custom2);
}


String strRequestBody = "body";
RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"),strRequestBody);