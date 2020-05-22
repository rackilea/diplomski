api.login(new BodyModel("peter@klaven"))
            .enqueue(new Callback<ExpectedModel>() {
                @Override
                public void onResponse(@NonNull Call<ExpectedModel> call, @NonNull Response<ExpectedModel> response) {
                    if (response.isSuccessful()) {
                        //Do what you got to do
                    } else {
                        Converter<ResponseBody, ErrorModel> converter = MainActivity.this.retrofit.responseBodyConverter(ErrorModel.class, new Annotation[0]);
                        ErrorModel errorModel = null;
                        try {
                            errorModel = converter.convert(response.errorBody());
                            Toast.makeText(MainActivity.this, errorModel.toString(), Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }

                @Override
                public void onFailure(@NonNull Call<ExpectedModel> call, @NonNull Throwable t) {
                    t.printStackTrace();
                }
            })