service.getFeed(new retrofit.Callback<Object>() {
    @Override
    public void success(Object obj, Response response) {
        Map<String, Object> data = (Map<String, Object>) ((Map<String, Object>) obj).get("data");
        Map<String, Object> cus_detail = (Map<String, Object>) data.get("cus_detail");
        String cus_unique_id = (String) cus_detail.get("cus_unique_id");
        Log.v("RETROFIT",obj.toString());
    }
    @Override
    public void failure(RetrofitError retrofitError) {
        System.out.println("RETROFIT_ERROR "+retrofitError);
    }
});