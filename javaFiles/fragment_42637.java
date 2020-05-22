//Check if Wallpaper Service is active
if(isMyServiceRunning(MyWallpaperService.class.getName())){
    Log.d(TAG, "active" );
} else {
    Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);
    startActivity(Intent.createChooser(intent, getActivity().getString(R.string.title_for_wallpaper_chooser)));
}