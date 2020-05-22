private class GetBeaconInfosTask extends AsyncTask<String, Void, Call<Url>> {

    Url url ;

    @Override
    protected Call<Url> doInBackground(String... urls) {
        ProxService service = ProxService.Factory.makeProxService(ProxService.ENDPOINT);
        return service.getUrlDetails(urls[0]);
    }

    // onPostExecute return the results of the AsyncTask.
    @Override
    protected void onPostExecute(Call<Url> call) {

        call.enqueue(new Callback<Url>() {
            @Override
            public void onResponse(Call<Url> call, Response<Url> response) {
                url = response.body();


                setShopLogo(url.icon) ;
                setShopName(url.title);
                setDescription(url.description);
                setlongUrl(url.longUrl); }
            }

            @Override
            public void onFailure(Call<Url> call, Throwable t) {
                //
            }
        });
}