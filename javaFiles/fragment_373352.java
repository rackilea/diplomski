getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, new ContentObserver(){
  @Override
  public void onChange(boolean selfChange, Uri uri){
    super.onChange(selfChange, uri);
    String key = uri.getPath();
    key = key.substring(key.lastIndexOf("/") + 1, key.length());

    if (key.equals("user_powersaver_enable") || key.equals("psm_switch")){
      boolean batterySaverEnabled = Settings.System.getString(getContentResolver(), key).equals("1");
      // do something
    }
  }
});