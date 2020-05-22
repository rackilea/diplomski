WallpaperManager wpm = WallpaperManager.getInstance(this);
    WallpaperInfo info = wpm.getWallpaperInfo();

    if (info != null && info.getPackageName().equals(this.getPackageName())) {
        Log.d(TAG, "We're already running");
    } else {
        Log.d(TAG, "We're not running");
    }