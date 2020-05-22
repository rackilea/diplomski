String state = Environment.getExternalStorageState();
if (Environment.MEDIA_MOUNTED.equals(state)) {
    Log.d("Test", "sdcard mounted and writable");
}
else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
    Log.d("Test", "sdcard mounted readonly");
}
else {
    Log.d("Test", "sdcard state: " + state);
}