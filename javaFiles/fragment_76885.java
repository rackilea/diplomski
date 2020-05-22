public Loader<String> onCreateLoader(int id, final Bundle args) {
      AsyncTaskLoader<String> loader = new AsyncTaskLoader<String>(this) {
            @Override
            protected void onStartLoading() {
                // No need to peform a query if no arguments were passed
                if (args == null) {
                    return;
                }
            }

            @Override
            public String loadInBackground() {
                /* some code */
            }

      };

      loader.forceLoad(); // This basically gonna run the loader.
      return loader;
}