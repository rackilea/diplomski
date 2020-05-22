Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
    try {
        PackageManager pm = mContext.getPackageManager();

        final ResolveInfo mInfo = pm.resolveActivity(i, 0);

        Intent intent = new Intent();
        intent.setComponent(new ComponentName(mInfo.activityInfo.packageName, mInfo.activityInfo.name));
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        startActivity(intent); 
    } catch (Exception e){ Log.i(TAG, "Unable to launch camera: " + e); }