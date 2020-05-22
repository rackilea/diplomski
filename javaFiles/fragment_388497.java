@GET("{numValue}/SmartService.svc")
public Call<List<Example>> getExample(
   @Path("num_value") int numValue,
   @Query("GetFundslistByPANIMEI") String panImei,
   @Query("Fund") String fund,
   @Query("APKVer") String apkVer,
   @Query("pan") String pan,
   @Query("Adminusername") String adminUsername,
   @Query("Adminpassword") String adminPassword)