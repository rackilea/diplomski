@Override
protected void onPostExecute(ArrayList<Media> mediaList){
   if (mlistener != null) 
    {
         mlistener.theMethod(mediaList);
    }
}