new AsyncTask<Void, Void, Task>() {
            @Override
            protected Task doInBackground(Void... params) {
                return flpc.requestLocationUpdates(locationRequest, pe);
            }

            @Override
            protected void onPostExecute(Task task) {
                onLocationUpdatesSuccess(task)
            }
    }.execute();