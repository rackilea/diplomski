if (wallpaperDrawable1==null)
{                       
    Resources res = getResources();
    Drawable drawable1=res.getDrawable(R.drawable.bg1);
    getWindow().setBackgroundDrawable(drawable1);

}
else
{
    getWindow().setBackgroundDrawable(wallpaperDrawable1);
}