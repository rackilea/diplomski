observeModelC()
        .subscribe(new Observer<ModelC>() {
            @Override
            public void onCompleted() {
                // All done.
            }

            @Override
            public void onError(Throwable e) {
                // All errors from any API request will end up here.
                // For Retrofit, cast e to RetrofitError for
                // detailed error info.
            }

            @Override
            public void onNext(ModelC modelC) {
                // Yeah! - Use modelC.
            }
        });