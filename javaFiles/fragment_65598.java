WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
Drawable wallpaperDrawable = wallpaperManager.getDrawable();
RelativeLayout ll = (RelativeLayout) findViewById(R.id.main);
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
    ll.setBackground(wallpaperDrawable);
}