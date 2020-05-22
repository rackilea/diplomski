service.getFeed(new retrofit.Callback<Data>() {
    @Override
    public void success(Data data, Response response) {
        String cus_unique_id = data.cus_detail.cus_unique_id;
        Log.v("RETROFIT",data.toString());
    }
    @Override
    public void failure(RetrofitError retrofitError) {
        System.out.println("RETROFIT_ERROR "+retrofitError);
    }
});