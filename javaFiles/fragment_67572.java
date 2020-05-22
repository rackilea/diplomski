private class GetImage extends AsyncTask<String,Bitmap,Void>{

    private ImageView view;
    Bitmap bitmap = null;
    long lastUpdateTimestamp = System.currentTimeMillis();
    public GetImage(ImageView iv){
         this.view = iv;
    }

    protected Bitmap doInBackground(String... params) {
                    //background thread
        while(running){
            try {
                //if more than 2 seconds have elapsed update the image
                if((System.currentTimeMillis() - lastUpdateTimestamp) > 2000){
                    bitmap = BitmapFactory.decodeStream((InputStream)new URL(params[0]).getContent());
                    pubilshProgress(bitmap);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                 e.printStackTrace();

            }
        }
        return null;

    }
    //this method that will update the UI
    @Override
    protected void onProgressUpdate(Bitmap... images){
        if(images[0] != null)
            this.view.setImageBitmap(images[0]);
        lastUpdateTimestamp = System.currentTimeMillis();
    }
    @Override
    protected void onPostExecute(Void unused){
        bitmap.recycle();
    }
    public void stopDownloading(){
        running = false;
    }
}