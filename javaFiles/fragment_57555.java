public class InnerClass extends AsyncTask {
    @Override
    protected Post doInBackground(Object[] objects) {
        APIServices mAPIServices = ApiUtils.getAPIService();
        Call<Post> ins= mAPIServices.savePost("test title", "test body", 12);
        Post ret=new Post();
        try {
            ret =ins.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}