// DataService service = ...;

// Define Callback
Callback<DataResponse> responseCallback = new Callback<DataResponse>() {

    @Override
    public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
        List<Feature> features = response.body().getFeatures();
        Log.d(TAG, "Data successfully downloaded");

        // Data is returned here
        for (Feature f: features) {
            Log.d("feature", String.valueOf(f)); // for example
        }
    }

    @Override
    public void onFailure(Call<DataResponse> call, Throwable t) {
        Log.e(TAG, t.toString());
    }
};

// Call it
service.getData(responseCallback);