protected void onPostExecute(ArrayList<Actors> result) {
        if(result != null) {
            /* CHANGE IN NEXT LINE */
            adaptor.ArrayListActors = result;

            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(getApplicationContext(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();
        }
    }