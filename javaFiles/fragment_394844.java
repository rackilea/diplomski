private class RefreshTruckInformation extends AsyncTask<URL, Void, Void> {

        private int[] b;
        public RefreshTruckInformation (int[] a){
             // use array
             b = a;
        }

        public void setArray(int[] a){
             // use array
             b = a;
        }

            @Override
        protected void doInBackground(URL... urls) {

        }

        @Override
        protected void onProgressUpdate(Integer... progress) {

        }

        @Override
        protected void onPostExecute(Void... voids) {

        }
    }