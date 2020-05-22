LoaderManager.LoaderCallbacks callbacks = new LoaderManager.LoaderCallbacks() {
        @Override
        public Loader onCreateLoader(int id, Bundle args) {
            return null;
        }

        @Override
        public void onLoadFinished(Loader loader, Object data) {

        }

        @Override
        public void onLoaderReset(Loader loader) {

        }

  getLoaderManager().initLoader(LOADER_MANAGER_ID, null, callback);