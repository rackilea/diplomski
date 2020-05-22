private void openAppDetailSettings(){
    String s =  Settings.ACTION_APPLICATION_DETAILS_SETTINGS;
    Intent intent = new Intent();
    intent.setAction(s);
    Uri uri = Uri.fromParts("package", BuildConfig.APPLICATION_ID, null);
    intent.setData(uri);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
}