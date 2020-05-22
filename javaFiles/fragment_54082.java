public interface Api {
    @GET("/getLastName")
    Call<ResponseBody> getLastName(@Query("name") List<String> names,
                                   @QueryMap Map<String, String> otherUniqueKeys);
}

List<String> names = new ArrayList();
names.add("yoni");
names.add("albert");

// create an instance of Api interface with retrofit
Api api = ...
api.getLastName(names).enqueue(new Callback<ResponseBody>() {
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

    }
});