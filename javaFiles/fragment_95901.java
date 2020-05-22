static boolean isCallable(Context ctxt, Intent intent) {

    if (intent == null) {
        return false;
    }
    List<ResolveInfo> list = ctxt.getPackageManager().queryIntentActivities(intent,
            PackageManager.MATCH_DEFAULT_ONLY);
    return list.size() > 0;

}