ImageAsyncTask task = new ImageAsyncTask(myImageView);

private class ImageAsyncTask extends AsyncTask<String, Void, Bitmap> {
    private ImageView img;

    ImageAsyncTask(Imageview img){
       this.img = img;
    }

  ... 

    protected void onPostExecute(Bitmap data) {
        this.img.setImageBitmap(data);

    }