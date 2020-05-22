class SyncTaskCounter extends AsyncTask<Void, Double, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            double price = 0;

            while (!isCancelled()) {
                price = price + 0.05;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(price); // this instructs to call onProgressUpdate from UI thread.
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Double... price) {
                printPrice(price[0]);  // this is called on UI thread
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }