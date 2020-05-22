RestClient restClient = new RestClient();
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                Categories_ = (Categories)o;
            }

            @Override
            public void failure(RetrofitError error) {
                Toast toast = Toast.makeText(getApplication(), "Something went wrong!!", Toast.LENGTH_SHORT);
                toast.show();
            }
        };
        restClient.getApiService().getCategories(callback);