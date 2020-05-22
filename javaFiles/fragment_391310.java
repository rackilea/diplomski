class GetImage extends AsyncTask<String, Void, Bitmap>
{
    private ImageView view;

    public GetImage(ImageView view)
    {
        this.view = view;
    }

    @Override
    protected Bitmap doInBackground(String... params)
    {
        //Your exact code goes here
    }

    @Override
    protected void onPostExecute(Bitmap b) 
    {
        view.setImageBitmap(b);
    }

}