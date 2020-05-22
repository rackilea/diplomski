public void GenerateLikeButton()
{
    application.runOnUiThread(new Runnable(){

        @Override
        public void run() {

            float x = 560 * game.global_scale;
            int width = (int) (440 * game.global_scale);
            int height = (int) (152* game.global_scale);
            float y_from_bottom = game.screen_height - ((56+152+70) * game.global_scale + game.ad_height);
            Gdx.app.log("like", "from bottom: "+ y_from_bottom);

            likeButton = new LikeView(application);
            likeButton.setLikeViewStyle(LikeView.Style.BUTTON);
            likeButton.setX(x);
            likeButton.setY(y_from_bottom-height);  

            likeButton.setObjectId(LIKE_URL);
            likeButton.setVisibility(View.GONE);
            application.layout.addView(likeButton,width,height);
            likeButton.invalidate();
        }
    });

}

@Override
public void ShowLikeButton(final boolean visible)
{
    application.runOnUiThread(new Runnable()
    {
        @Override
        public void run() 
        {
            if(visible)
                likeButton.setVisibility(View.VISIBLE);
            else
                likeButton.setVisibility(View.GONE);
        }
    });
}