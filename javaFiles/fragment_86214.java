@Override
        protected void onPostExecute(Void result) {
             // call populateListView method here
            populateListView();
            super.onPostExecute(result);
        }