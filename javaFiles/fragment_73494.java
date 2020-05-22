BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(new DataProxy<PagingLoadResult<ModelData>>() {

        @Override
        public void load(DataReader<PagingLoadResult<ModelData>> reader,
                Object loadConfigAsObject, AsyncCallback<PagingLoadResult<ModelData>> callback) {

            BasePagingLoadConfig loadConfig = (BasePagingLoadConfig) loadConfigAsObject;

            // Get the results for the requested page...

            BasePagingLoadResult<ModelData> pagingLoadResult = new BasePagingLoadResult<ModelData>(...);
            callback.onSuccess(pagingLoadResult);
        }
    });