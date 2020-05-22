@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public Response<List<Store>> getSubprises() throws IOException, ExecutionException, InterruptedException {
    LongOperation longOperation = new LongOperation();
    longOperation.execute("");
    stores = longOperation.get();
    return stores;
}

private class LongOperation extends AsyncTask<String, Void, Response<List<Store>>> {
    @Override
    protected Response<List<Store>> doInBackground(String... params) {
        //System.out.println("doInBackground executed second");
        try {
            Call<List<Store>> call = subpriseAPI.listStores();
            stores=call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stores;
    }

    @Override
    protected void onPreExecute() {
        //Can't put the call here because this is the main thread
        //System.out.println("onPreExecute first");
    }

    @Override
    protected void onPostExecute(Response<List<Store>> result) {
        //Can't put the call here because this is the main thread
    }
}