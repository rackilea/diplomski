TextView content = mView.findViewById(R.id.content);

String myHtml = "This will display an image to the right <img src='https://i-vnexpress.vnecdn.net/2019/06/06/trump-1571-1559784498.jpg' />";


content.setText(Html.fromHtml(myHtml, Images, null));


    private Html.ImageGetter Images = new Html.ImageGetter() {

        public Drawable getDrawable(String source) {

            Drawable drawable = null;

            FetchImageUrl fiu = new FetchImageUrl(getActivity(),source);
            try {
                fiu.execute().get();
                drawable = fiu.GetImage();
            }
            catch (Exception e) {
                drawable = getResources().getDrawable(R.drawable.default_icon);
            }
            // to display image,center of screen

            if(drawable!=null) {
                int imgH = drawable.getIntrinsicHeight();
                int imgW = drawable.getIntrinsicWidth();
                int padding = 20;
                int realWidth = 700; //ScreenW-(2*padding);
                int realHeight = imgH * realWidth / imgW;
                drawable.setBounds(padding, 0, realWidth, realHeight);
            }
            return drawable;
        }
    };


    public class FetchImageUrl extends AsyncTask<String, String, Boolean> {


        String imageUrl;
        Context context;
        protected Drawable image;

        public FetchImageUrl(Context context, String url)
        {
            this.imageUrl = url;
            image = null;
            this.context = context;
        }

        public Drawable GetImage()
        {
            return image;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... args) {
            try {
                InputStream input_stream = (InputStream) new URL(imageUrl).getContent();
                image = Drawable.createFromStream(input_stream, "src name");
                return true;

            }
            catch (Exception e)
            {
                image = null;
            }
            return false;
        }


        @Override
        protected void onPostExecute(Boolean result) {

        }}