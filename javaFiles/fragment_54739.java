protected void onPostExecute(Boolean result) {
        dialog.cancel();           
        if(result == false)
            Toast.makeText(getApplicationContext(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();
        if(actorsList != null) {
            adapter = new ActorAdapter(getApplicationContext(), R.layout.row, actorsList);      
            centerLockHorizontalScrollview.setAdapter(MainActivity.this, adapter); 
        }
        adapter.notifyDataSetChanged();
    }
}