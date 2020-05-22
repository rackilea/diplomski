private class getData extends AsyncTask<Void, Void, List<POI>>{
            @Override
            protected List<POI> doInBackground(Void... params) {
                return todosPOIs();
            }

            @Override
            protected void onPostExecute(List<POI> result) {
                if(result.size > 0){
                    //Do with the result whatever you want
                }
            }