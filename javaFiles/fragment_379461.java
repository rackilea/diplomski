private class BgTask extends AsyncTask<Void, Void, Boolean> {

  @Override
  protected Boolean doInBackground(Void... params) {
  //TODO - Call getFeeds Method to populate feeds list & return true/false depending on result of operation
   try {
    feeds = getFeeds();
   } catch(Exception e){
    e.printStackTrace();
    return false;
   }
   return true;
  }

  @Override
  protected void onPostExecute(Boolean result) {
   if(result){
    lfa = new ListFeedAdapter(YourActivity.this, feeds);
    feedView.setAdapter(lfa);
   }
  }

}