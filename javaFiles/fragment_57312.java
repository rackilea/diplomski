private void extendSession(String token){
   Map params = buildDefaultParams();
   params.put("refreshToken", token);
   getRestAdapter().create(MyApi.class).extendsSession(params);
}
private Map buildDefaultParams(){
   Map defaults = new HashMap();
   defaults.put("client_id", CLIENT_ID);
   defaults.put("client_secret", CLIENT_SECRET);
   defaults.put("grant_type", GRANT_TYPE);
   return defaults;
}
  /**then you change your interface to this **/ 
    @POST("/token")
    @FormUrlEncoded
    void extendSession(@FieldMap() Map refreshToken);