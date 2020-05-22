appExecutors.diskIO().execute(() -> {
                saveCallResult(processResponse(response));
                appExecutors.mainThread().execute(() ->
                        // we specially request a new live data,
                        // otherwise we will get immediately last cached value,
                        // which may not be updated with latest results received from network.
                        result.addSource(loadFromDb(),
                                newData -> result.setValue(Resource.success(newData)))
                );
            });