void open(Activity activity, String url) {
    Uri uri = Uri.parse("googlechrome://navigate?url=" + url);
    Intent i = new Intent(Intent.ACTION_VIEW, uri);
    if (i.resolveActivity(activity.getPackageManager()) == null) {
        i.setData(Uri.parse(url));
    }
    activity.startActivity(i);
}