private class GetImage extends AsyncTask<String,Void,Bitmap>{

    private ImageView view;

    public GetImage(ImageView iv){
         this.view = iv;
    }

    protected Bitmap doInBackground(String... params) {
                    //background thread
        try {

            return BitmapFactory.decodeStream((InputStream)new URL(params[0]).getContent());
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

        return null;

    }
    @Override
    protected void onPostExecute(Bitmap b){
        if(b != null)
            this.view.setImageBitmap(b); 
    }
}