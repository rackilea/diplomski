class LoadImage extends AsyncTask<URL, Void, Bitmap> {

    ProgressDialog myPd_ring;

    @Override
    protected void onPreExecute() {
        //Start Progress Dialog here
        myPd_ring = ProgressDialog.show(SingleWall.this, "Setting wallpaper", "", true);
    }

    //Runs in a background Thread
    @Override
    protected Bitmap doInBackground(URL... params) {
        URL url = params[0];
        Bitmap image = null;
        try {
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    //Runs on the UI Thread
    @Override
    protected void onPostExecute(Bitmap image) {
        myPd_ring.dismiss();

        if (image == null){
            Toast.makeText(SingleWall.this, "Setting WallPaper Failed!!", Toast.LENGTH_LONG).show();
        }
        else{
            //set image here
            try {
                SingleWall.this.wallManager.setBitmap(image);

                Toast.makeText(SingleWall.this, "Wallpaper Set Successfully!!", Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(SingleWall.this, "Setting WallPaper Failed!!", Toast.LENGTH_LONG).show();
            }

        }
    }
}